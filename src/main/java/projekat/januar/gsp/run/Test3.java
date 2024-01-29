package projekat.januar.gsp.run;

import org.hibernate.Session;
import projekat.januar.gsp.model.Kategorija;
import projekat.januar.gsp.model.Vozac;
import projekat.januar.gsp.run.abstraction.Test;
import projekat.januar.gsp.run.utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test3 implements Test {
    @Override
    public void test() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Vozac> voziloCriteriaQuery
                = criteriaBuilder.createQuery(Vozac.class);
        voziloCriteriaQuery.from(Vozac.class);
        List<Vozac> vanzemaljci
                = session.createQuery(voziloCriteriaQuery).getResultList();
        vanzemaljci.sort(Comparator.comparingLong(Vozac::getVozacId));
        Map<Kategorija, Integer> broj_vozaca = new HashMap<>();
        for (Vozac v : vanzemaljci) {
            if (broj_vozaca.containsKey(v.getKategorija())){
                Integer vr = broj_vozaca.get(v.getKategorija());
                broj_vozaca.put(v.getKategorija(), vr+1);
            }
            else broj_vozaca.put(v.getKategorija(), 1);
        }
        System.out.println("Za svaku kategoriju vozača izračunati koliko vozača pripada toj kategoriji.");
        System.out.println(broj_vozaca);
        session.getTransaction().commit();
    }
}
