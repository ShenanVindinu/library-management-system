package lk.ijse.custom;

import java.util.Date;

public class BookHistoryQueryResult {
    private String bookName;
    private Date dueDate;
    private boolean returned;
    private String username;

    public BookHistoryQueryResult(String bookName, Date dueDate, String username) {
        this.bookName = bookName;
        this.dueDate = dueDate;
        this.username = username;
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

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
