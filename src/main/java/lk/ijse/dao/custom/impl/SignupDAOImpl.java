package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.SignupDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SignupDAOImpl implements SignupDAO {

    @Override
    public Long existUsername(String userName) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        String hql = "SELECT COUNT(u) FROM User u WHERE u.userName =:inputUserName";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("inputUserName", userName);

        return query.uniqueResult();
    }

    @Override
    public void save(User user) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user,String password) {
        user.setPassword(password);
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }
}
