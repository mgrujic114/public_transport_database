package projekat.januar.gsp.run;

import org.hibernate.Session;
import org.hibernate.Transaction;
import projekat.januar.gsp.model.Linija;
import projekat.januar.gsp.model.Vozilo;
import projekat.januar.gsp.run.abstraction.Test;
import projekat.januar.gsp.run.utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 implements Test {
    @Override
    public void test() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Vozilo> voziloCriteriaQuery
                    = criteriaBuilder.createQuery(Vozilo.class);
            voziloCriteriaQuery.from(Vozilo.class);
            List<Vozilo> vanzemaljci
                    = session.createQuery(voziloCriteriaQuery).getResultList();
            vanzemaljci.sort(Comparator.comparingLong(Vozilo::getVoziloId));
            Integer ukupno = 0;
            Map<Linija, Integer> polasci = new HashMap<>();
            for (Vozilo v : vanzemaljci) {
                if (parsiraj(v.getDatumEvaluacije())) ukupno++;
            }

            System.out.println("Izračunati koliko je vozila po potkategoriji bilo uspešno evaluirano bar jednom u toku 2023.godine.");
            System.out.println("Ukupno vozila: " + ukupno);
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

    private boolean parsiraj(String datumEvaluacije) {
        String[] split = datumEvaluacije.split("-");
        if (split[2].equals("23")) return true;
        else return false;
    }
}
