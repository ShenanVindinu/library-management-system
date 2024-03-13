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
    private String userName;
    @Column(name = "book_name")
    private String bookName;
    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;
    @OneToMany(mappedBy = "bookHistory")
    private List<Book> books = new ArrayList<>();
    @OneToOne
    private User user;

    public BookHistory() {
    }

    public BookHistory(int hId, boolean returned, String userName, String bookName, Date dueDate, List<Book> books, User user) {
        this.hId = hId;
        this.returned = returned;
        this.userName = userName;
        this.bookName = bookName;
        this.dueDate = dueDate;
        this.books = books;
        this.user = user;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                ", userName='" + userName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", dueDate=" + dueDate +
                ", books=" + books +
                ", user=" + user +
                '}';
    }


}
