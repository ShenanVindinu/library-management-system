package lk.ijse.dao;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.User;
import org.hibernate.Session;
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

}
