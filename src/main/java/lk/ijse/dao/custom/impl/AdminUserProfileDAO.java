package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AdminUserProfileDAO {

    public Branch fetchBranchByName(String branchName) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Query<Branch> query = session.createQuery("FROM Branch WHERE branch = :branchName", Branch.class);
        query.setParameter("branchName", branchName);
        Branch branch = query.uniqueResult();
        session.close();
        return branch;
    }

    public Book findBook(String title)  {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query<Book> query = session.createQuery("FROM Book WHERE bookName = :title", Book.class);
        query.setParameter("title", title);
        Book book = query.uniqueResult();
        session.close();
        return book;
    }

    public void updateBook(Book book, String author, String genre, Branch branch) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        book.setAuthor(author);
        book.setGenre(genre);
        book.setBranch(branch);
        session.merge(book);
        transaction.commit();
        session.close();
    }

    public void removeBranch(Branch branch) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(branch);
        transaction.commit();
        session.close();
    }

    public void removeReference(Book book) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        book.getBranch().getBookList().remove(book);
        session.remove(book);
        transaction.commit();
        session.close();
    }

    public void saveBranch(Branch branch) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(branch);
        transaction.commit();
        session.close();
    }

    public void saveBook(Book book) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
    }

}
