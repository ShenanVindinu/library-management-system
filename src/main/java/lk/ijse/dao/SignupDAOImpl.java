package lk.ijse.dao;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SignupDAOImpl {

    public Long existUsername(String userName) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        String hql = "SELECT COUNT(u) FROM User u WHERE u.userName =:inputUserName";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("inputUserName", userName);

        Long value = query.uniqueResult();
        return value;
    }

    public void save(User user) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }
}
