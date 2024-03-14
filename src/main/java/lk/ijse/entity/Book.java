package lk.ijse.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    String bookName;
    boolean availability;
    String author;
    String genre;
    @ManyToOne
    private Branch branch;
    @ManyToOne
    private BookHistory bookHistory;

    public Book() {
    }

    public Book(String bookName, boolean availability, String author, String genre) {
        this.bookName = bookName;
        this.availability = availability;
        this.author = author;
        this.genre = genre;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public BookHistory getBookHistory() {
        return bookHistory;
    }

    public void setBookHistory(BookHistory bookHistory) {
        this.bookHistory = bookHistory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", availability=" + availability +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", branch=" + branch +
                ", bookHistory=" + bookHistory +
                '}';
    }


}
