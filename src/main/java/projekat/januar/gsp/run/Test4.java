package projekat.januar.gsp.run;

import org.hibernate.Session;
import projekat.januar.gsp.model.Kategorija;
import projekat.januar.gsp.model.RadnoVreme;
import projekat.januar.gsp.model.Vozac;
import projekat.januar.gsp.run.abstraction.Test;
import projekat.januar.gsp.run.utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 implements Test {
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
        Integer broj_vozaca = 0;
        RadnoVreme rv;
        for (Vozac v : vanzemaljci) {

        }
        System.out.println(broj_vozaca);
        session.getTransaction().commit();
    }
}
