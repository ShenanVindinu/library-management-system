package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AdminUserProfileBO;
import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.AdminUserProfileDAO;
import lk.ijse.dao.custom.LoginDAO;
import lk.ijse.dao.custom.impl.AdminUserProfileDAOImpl;
import lk.ijse.dao.custom.impl.LoginDAOImpl;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdminUserProfileBOImpl implements AdminUserProfileBO {

    AdminUserProfileDAO adminUserProfileDAOImpl = new AdminUserProfileDAOImpl();
    LoginDAO loginDAO  = new LoginDAOImpl();

    @Override
    public Branch getBranchByName(String branchName) {
       return adminUserProfileDAOImpl.fetchBranchByName(branchName);
    }

    @Override
    public Book findBookByName(String title) {
        return adminUserProfileDAOImpl.findBook(title);
    }

    @Override
    public void updateBookDetails(Book book, String author, String genre, Branch branch) {
        adminUserProfileDAOImpl.updateBook(book,author,genre,branch);
    }

    @Override
    public void removeBranches(Branch branch) {
        adminUserProfileDAOImpl.removeBranch(branch);
    }

    @Override
    public void removingAssociatedReferences(Book book) {
        adminUserProfileDAOImpl.removeReference(book);
    }

    @Override
    public void savingBranchToTable(Branch branch) {
        adminUserProfileDAOImpl.saveBranch(branch);
    }

    @Override
    public void saveBookToTable(Book book) {
        adminUserProfileDAOImpl.saveBook(book);
    }

    @Override
    public List<Book> searchBooks(String searchTerm)  {
        return adminUserProfileDAOImpl.search(searchTerm);
    }

    @Override
    public User findUserByUsername(String username) {
        return loginDAO.getUserName(username);
    }

    @Override
    public List<Book> getBooksByBranch(Branch branch) {
        return adminUserProfileDAOImpl.findBookByBranch(branch);
    }


}
