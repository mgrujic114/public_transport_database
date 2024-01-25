package projekat.januar.gsp.run;

import org.hibernate.Session;
import projekat.januar.gsp.run.abstraction.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class Test04 implements Test {
    @Override
    public void test() {
        Session session
                = HibernateUtils.getSessionFactory().getCurrentSession();
//
//        session.beginTransaction();
//
//        CriteriaBuilder criteriaBuilder
//                = session.getCriteriaBuilder();
//        CriteriaQuery<Drzava> drzavaCriteriaQuery
//                = criteriaBuilder.createQuery(Drzava.class);
//        drzavaCriteriaQuery.from(Drzava.class);
//
//        List<Drzava> drzavePocetno
//                = session.createQuery(drzavaCriteriaQuery).getResultList();
//        List<Drzava> drzave = new ArrayList<>();
//        for (Drzava d : drzavePocetno) {
//            if (d.getKontinent().getRegija().getNazivRegije().equals("Evropa"))
//                drzave.add(d);
//        }
//        for (Drzava d : drzave) {
//            System.out.println(d.getRegija().getNazivRegije());
//        }
//
//        session.getTransaction().commit();
    }
}
