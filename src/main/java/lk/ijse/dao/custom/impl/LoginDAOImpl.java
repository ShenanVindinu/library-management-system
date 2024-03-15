package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.LoginDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public User getUserNamePassword(String userName, String password) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        String hql = "FROM User u WHERE u.userName = :inputUserName AND u.password = :inputPassword";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("inputUserName", userName);
        query.setParameter("inputPassword", password);

        User user = query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User getUserName(String username) {
        User user = null;
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("FROM User WHERE userName = :userName", User.class);
        query.setParameter("userName", username);
        user = query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }

}
