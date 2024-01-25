package projekat.januar.gsp.run;

import org.hibernate.Session;
import projekat.januar.gsp.run.abstraction.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Test05 implements Test {
    @Override
    public void test() {
        Session session
                = HibernateUtils.getSessionFactory().getCurrentSession();

//        session.beginTransaction();
//
//        CriteriaBuilder criteriaBuilder
//                = session.getCriteriaBuilder();
//        CriteriaQuery<Kontinent> kontinentCriteriaQuery
//                = criteriaBuilder.createQuery(Kontinent.class);
//        kontinentCriteriaQuery.from(Kontinent.class);
//
//        List<Kontinent> kontinenti
//                = session.createQuery(kontinentCriteriaQuery).getResultList();
//        for (Kontinent k : kontinenti) {
//            System.out.println(k.getRegija().getNazivRegije()
//                                + k.getDrzave().size());
//        }
//
//        session.getTransaction().commit();
    }

    private static class Result {

//        private final Kontinent kontinent;
//        private final int brojDrzava;
//
//        private Result(Kontinent kontinent, int brojDrzava) {
//            this.kontinent = kontinent;
//            this.brojDrzava = brojDrzava;
//        }
//
//        @Override
//        public String toString() {
//            return this.kontinent.getRegija().getNazivRegije()
//                    + "\t" + this.brojDrzava;
//        }
    }
}
