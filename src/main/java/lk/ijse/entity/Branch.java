package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {

    @Id
    @Column(name = "Branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int branchId;
    String branch;
    @OneToMany(mappedBy = "branch")
    private List<Book> bookList = new ArrayList<>();

    public Branch() {
    }

    public Branch(int branchId, String branch, List<Book> bookList) {
        this.branchId = branchId;
        this.branch = branch;
        this.bookList = bookList;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branch='" + branch + '\'' +
                ", bookList=" + bookList +
                '}';
    }


}
