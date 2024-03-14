package lk.ijse.bo.custom.impl;

import lk.ijse.dao.custom.impl.AdminUserProfileDAO;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

public class AdminUserProfileBO {

    AdminUserProfileDAO adminUserProfileDAO = new AdminUserProfileDAO();

    public Branch getBranchByName(String branchName) {
       return adminUserProfileDAO.fetchBranchByName(branchName);
    }

    public Book findBookByName(String title) {
        return adminUserProfileDAO.findBook(title);
    }

    public void updateBookDetails(Book book, String author, String genre, Branch branch) {
        adminUserProfileDAO.updateBook(book,author,genre,branch);
    }

    public void removeBranches(Branch branch) {
        adminUserProfileDAO.removeBranch(branch);
    }

    public void removingAssociatedReferences(Book book) {
        adminUserProfileDAO.removeReference(book);
    }

    public void savingBranchToTable(Branch branch) {
        adminUserProfileDAO.saveBranch(branch);
    }

    public void saveBookToTable(Book book) {
        adminUserProfileDAO.saveBook(book);
    }
}
