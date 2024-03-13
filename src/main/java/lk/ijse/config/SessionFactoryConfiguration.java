package lk.ijse.config;

import lk.ijse.entity.Book;
import lk.ijse.entity.BookHistory;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Purpose of creating this class to do the necessary Session Factory Configurations
 * by creating;
 * 1. Service Registry
 * 2. Metadata Object
 * 3. Session Factory
 * 4. Session Object
 */
public class SessionFactoryConfiguration {

    private static SessionFactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    /**
     * Private Default Constructor
     * Restricts creating new instances again and again
     * from this class from outside this class
     */
    private SessionFactoryConfiguration() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class).addAnnotatedClass(Branch.class).addAnnotatedClass(Book.class)
                .addAnnotatedClass(BookHistory.class);
        sessionFactory=configuration.mergeProperties(properties).buildSessionFactory();
    }

    /**
     * @return lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration
     * Purpose of this method is to get an Instance of this same class
     * by limiting the object recreation (Limiting again and again Object creation)
     */
    public static SessionFactoryConfiguration getInstance() {
        return (null == factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfiguration()
                : factoryConfiguration;
    }

    /**
     * @return org.hibernate.Session
     * @throws HibernateException
     * Purpose of this method is to get a Session from the Session Factory
     */
    public Session getSession() throws HibernateException {
        // Opens a new Session through the Session Factory & returns the Session created
        return sessionFactory.openSession();
    }
}