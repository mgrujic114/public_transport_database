package projekat.januar.gsp.run;

import org.hibernate.Session;
import projekat.januar.gsp.run.abstraction.Test;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.List;

public class Test03 implements Test {
    @Override
    public void test() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        CriteriaBuilder criteriaBuilder
//                = session.getCriteriaBuilder();
//        CriteriaQuery<Vanzemaljac> vanzemaljacCriteriaQuery
//                = criteriaBuilder.createQuery(Vanzemaljac.class);
//        vanzemaljacCriteriaQuery.from(Vanzemaljac.class);
//
//        List<Vanzemaljac> vanzemaljci
//                = session.createQuery(vanzemaljacCriteriaQuery).getResultList();
//        vanzemaljci.sort(Comparator.comparingInt(Vanzemaljac::getVanzemaljacId));
//        for (Vanzemaljac v : vanzemaljci) {
//            System.out.println(
//                    v.getVanzemaljacId() + "\t" + v.getRegija().getNazivRegije());
//        }
//
//        session.getTransaction().commit();
    }
}
