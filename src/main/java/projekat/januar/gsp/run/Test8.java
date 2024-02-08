package projekat.januar.gsp.run;

import org.hibernate.Session;
import org.hibernate.Transaction;
import projekat.januar.gsp.model.Linija;
import projekat.januar.gsp.model.RedVoznje;
import projekat.januar.gsp.run.abstraction.Test;
import projekat.januar.gsp.run.utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test8 implements Test {
    @Override
    public void test() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<RedVoznje> voziloCriteriaQuery
                    = criteriaBuilder.createQuery(RedVoznje.class);
            voziloCriteriaQuery.from(RedVoznje.class);
            List<RedVoznje> vanzemaljci
                    = session.createQuery(voziloCriteriaQuery).getResultList();
            vanzemaljci.sort(Comparator.comparingLong(RedVoznje::getRedVoznjeId));
            String najvise = vanzemaljci.get(0).getLinija().getRedniBroj().toString();
            String najmanje = vanzemaljci.get(0).getLinija().getRedniBroj().toString();
            Map<String, Integer> polasci = new HashMap<>();

            for (RedVoznje v : vanzemaljci) {
                if (polasci.containsKey(v.getLinija())) {
                    Integer vr = polasci.get(v.getLinija());
                    polasci.put(v.getLinija().getRedniBroj()+" "+v.getSmer(), vr + 1);
                } else polasci.put(v.getLinija()+" "+v.getSmer(), 1);
            }

            Integer najvisePolazaka = 0;
            Integer najmanjePolazaka = 1000;

            for (String key : polasci.keySet()) {
                if (polasci.get(key) > najvisePolazaka) {
                    najvisePolazaka = polasci.get(key);
                    najvise = key;
                }
                else if (polasci.get(key) < najmanjePolazaka){
                    najmanjePolazaka = polasci.get(key);
                    najmanje = key;
                }
            }

            System.out.println("Ispisati redni broj linije sa najviše i liniju sa najmanje polazaka.");
            System.out.println("Linija sa najvise: " + najvise +
                    "\nLinija sa najmanje: " + najmanje);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
