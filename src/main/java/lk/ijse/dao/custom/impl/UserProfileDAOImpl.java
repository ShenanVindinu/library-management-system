package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.BookHistory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserProfileDAOImpl {

    public void add(BookHistory bookHistory) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(bookHistory);
        transaction.commit();
        session.close();
    }
    public void update(BookHistory bookHistory) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(bookHistory);
        transaction.commit();
        session.close();
    }

}
