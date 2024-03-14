package lk.ijse.dao.custom;

import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

public interface AdminUserProfileDAO {

    Branch fetchBranchByName(String branchName);

    Book findBook(String title);

    void updateBook(Book book, String author, String genre, Branch branch);

    void removeBranch(Branch branch);

    void removeReference(Book book);

    void saveBranch(Branch branch);

    void saveBook(Book book);

}
