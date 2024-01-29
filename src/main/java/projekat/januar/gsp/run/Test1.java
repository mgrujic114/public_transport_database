package projekat.januar.gsp.run;

import org.hibernate.Session;
import org.hibernate.Transaction;
import projekat.januar.gsp.model.Vozilo;
import projekat.januar.gsp.run.abstraction.Test;
import projekat.januar.gsp.run.utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.List;

public class Test1 implements Test {
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
            Integer ukupanBrojMesta = 0;
            Integer stajanje = 0;
            Integer sedenje = 0;
            for (Vozilo v : vanzemaljci) {
                stajanje += v.getBrojMestaZaStajanje();
                sedenje += v.getBrojMestaZaSedenje();
                ukupanBrojMesta += v.getBrojMestaZaSedenje() + v.getBrojMestaZaStajanje();
            }
            System.out.println("Izračunati koliko ukupno mesta postoji u gradskom prevozu.\n " +
                    "Izračunati takođe koliko je mesta za stajanje i koliko je mesta za sedenje.");
            System.out.println("Ukupan broj mesta " + ukupanBrojMesta +
                    "\nBroj mesta za sedenje: " + sedenje + ", broj mesta za stajanje: " + stajanje);
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
