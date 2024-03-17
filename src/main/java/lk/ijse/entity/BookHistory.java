package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class BookHistory {

    @Id
    @Column(name = "h_id")
    private int hId;
    private boolean returned;
    @Column(name = "book_name")
    private String bookName;
    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;
    @OneToMany(mappedBy = "bookHistory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private User user;


    public BookHistory() {
    }


    public BookHistory(String bookName, Date dueDate, boolean returned) {
        this.bookName = bookName;
        this.dueDate = dueDate;
        this.returned = returned;
    }



    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookHistory{" +
                "hId=" + hId +
                ", returned=" + returned +
                ", bookName='" + bookName + '\'' +
                ", dueDate=" + dueDate +
                ", books=" + books +
                ", user=" + user +
                '}';
    }
}
