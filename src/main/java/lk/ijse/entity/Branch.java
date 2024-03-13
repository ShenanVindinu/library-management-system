package lk.ijse.entity;

import jakarta.persistence.*;

@Entity
public class Branch {

    @Id
    @Column(name = "Branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int branchId;
    String branch;

    public Branch() {
    }

    public Branch(int branchId, String branch) {
        this.branchId = branchId;
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

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branch='" + branch + '\'' +
                '}';
    }

}
