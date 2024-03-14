package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {

    @Id
        @Column(name = "Branch_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;

    @Column(name = "Branch_name")
    private String branch;


    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();


    public Branch() {
    }


    public Branch(String branch) {
        this.branch = branch;
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
