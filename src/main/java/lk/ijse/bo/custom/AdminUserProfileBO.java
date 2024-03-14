package lk.ijse.bo.custom;

import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

public interface AdminUserProfileBO {

    Branch getBranchByName(String branchName);

    Book findBookByName(String title);

    void updateBookDetails(Book book, String author, String genre, Branch branch);

    void removeBranches(Branch branch);

    void removingAssociatedReferences(Book book);

    void savingBranchToTable(Branch branch);

    void saveBookToTable(Book book);

}
