package projekat.januar.gsp.run;

import org.hibernate.Session;
import projekat.januar.gsp.model.Vozilo;
import projekat.januar.gsp.run.abstraction.Test;
import projekat.januar.gsp.run.utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.List;

public class Test01 implements Test {
    @Override
    public void test() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Vozilo> voziloCriteriaQuery
                = criteriaBuilder.createQuery(Vozilo.class);
        voziloCriteriaQuery.from(Vozilo.class);
        List<Vozilo> vanzemaljci
                = session.createQuery(voziloCriteriaQuery).getResultList();
        vanzemaljci.sort(Comparator.comparingLong(Vozilo::getVoziloId));
        Integer ukupanBrojMesta = 0;
        for (Vozilo v : vanzemaljci) {
            ukupanBrojMesta+=v.getBrojMestaZaSedenje()+v.getBrojMestaZaStajanje();
        }
        System.out.println(ukupanBrojMesta);
        session.getTransaction().commit();
    }
}
