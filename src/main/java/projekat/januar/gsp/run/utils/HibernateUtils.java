package projekat.januar.gsp.run.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import projekat.januar.gsp.model.*;

import java.util.Properties;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    private static SessionFactory sessionAnnotationFactory;

    private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Vozilo.class);
            configuration.addAnnotatedClass(TipVozila.class);
            configuration.addAnnotatedClass(PodtipVozila.class);
            configuration.addAnnotatedClass(Garaza.class);
            configuration.addAnnotatedClass(Vozac.class);
            configuration.addAnnotatedClass(Kategorija.class);
            configuration.addAnnotatedClass(RadnoVreme.class);
            configuration.addAnnotatedClass(Terminus.class);
            configuration.addAnnotatedClass(Stajaliste.class);
            configuration.addAnnotatedClass(Linija.class);
            configuration.addAnnotatedClass(Telefon.class);
            configuration.addAnnotatedClass(PreduzeceZaProdajuVozila.class);
            configuration.addAnnotatedClass(TipStajalista.class);
            configuration.addAnnotatedClass(Zona.class);
            configuration.addAnnotatedClass(RedVoznje.class);
            configuration.addAnnotatedClass(Smer.class);
            configuration.addAnnotatedClass(PovlascenaKarta.class);
            configuration.addAnnotatedClass(TipPovalstice.class);
            configuration.addAnnotatedClass(Karta.class);
            configuration.addAnnotatedClass(Smena.class);
            configuration.addAnnotatedClass(PeriodVazenja.class);
            configuration.addAnnotatedClass(TipGaraze.class);
            //configuration.addAnnotatedClass(KategorijaVozila.class);
//            configuration.addAnnotatedClass(Vanzemaljac.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory
                    = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate-annotation.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
            Configuration configuration = getConfiguration();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        Properties props = new Properties();
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost/TestDB");
        props.put("hibernate.connection.username", "pankaj");
        props.put("hibernate.connection.password", "pankaj123");
        props.put("hibernate.current_session_context_class", "thread");
        configuration.setProperties(props);
        configuration.addAnnotatedClass(Vozilo.class);

        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }

    public static SessionFactory getSessionJavaConfigFactory() {
        if(sessionJavaConfigFactory == null) sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }

    private HibernateUtils() {

    }
}
