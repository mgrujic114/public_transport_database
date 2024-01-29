package projekat.januar.gsp.run;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Vozac> voziloCriteriaQuery
                    = criteriaBuilder.createQuery(Vozac.class);
            voziloCriteriaQuery.from(Vozac.class);
            List<Vozac> vanzemaljci
                    = session.createQuery(voziloCriteriaQuery).getResultList();
            vanzemaljci.sort(Comparator.comparingLong(Vozac::getVozacId));
            Integer brojVozaca = 0;
            RadnoVreme rv;
            String radniDan;
            String subota;
            String nedelja;
            Double ukupnoRadnoVreme=0.00;

            for (Vozac v : vanzemaljci) {
                rv = v.getRadnoVreme();
                radniDan = rv.getRadniDan();
                subota = rv.getSubota();
                nedelja = rv.getNedelja();
                if (! (radniDan.equalsIgnoreCase("neradni dan"))){
                    ukupnoRadnoVreme+=parsiraj(radniDan)*5;
                }
                if (! (subota.equalsIgnoreCase("neradni dan"))){
                    ukupnoRadnoVreme+=parsiraj(subota);
                }
                if (! (nedelja.equalsIgnoreCase("neradni dan"))){
                    ukupnoRadnoVreme+=parsiraj(nedelja);
                }
                if (ukupnoRadnoVreme>40){
                    brojVozaca++;
                }
                ukupnoRadnoVreme=0.0;
            }
            System.out.println("Izračunati koliko vozača radi više od 40h nedeljno.");
            System.out.println("Vise od 40h nedeljno radi: " + brojVozaca + " vozaca");
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

    private Double parsiraj(String radniDan){
        String pocetakSat;
        String krajSat;
        String pocetakMinut;
        String krajMinut;
        String[] pars1 = radniDan.split("-");
        String[] pars2 = pars1[0].split(":");
        String[] pars3 = pars1[1].split(":");
        pocetakSat = pars2[0];
        pocetakMinut = pars2[1];
        krajSat = pars3[0];
        krajMinut = pars3[1];

        Double pS = Double.parseDouble(pocetakSat);
        Double pM = Double.parseDouble(pocetakMinut)/60;
        Double kS = Double.parseDouble(krajSat);
        Double kM = Double.parseDouble(krajMinut)/60;
        Double sati = kS-pS;
        Double minuti = kM-pM;

        Double rez = sati-minuti;
        return rez;

    }
}
