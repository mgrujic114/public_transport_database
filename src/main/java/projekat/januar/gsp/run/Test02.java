package projekat.januar.gsp.run;

import org.hibernate.Session;
import projekat.januar.gsp.run.abstraction.Test;
import projekat.januar.gsp.run.utils.HibernateUtils;


public class Test02 implements Test {
    @Override
    public void test() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Regija regija = session.load(Regija.class, 1);
//        Vanzemaljac vanzemaljac = new Vanzemaljac();
//        vanzemaljac.setRegija(regija);
//        session.save(vanzemaljac);
//        session.getTransaction().commit();
    }
}
