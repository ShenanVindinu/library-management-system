package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;

public class AdminUserProfileController {

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField genreField;

    @FXML
    private TextField BookBranchField;

    @FXML
    private TextField branchField;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button addBookButton;

    @FXML
    private Button addBranchButton;

    @FXML
    private Button boolManagerButton;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private Button removeBookButton;

    @FXML
    private Button removeBranchButton;

    @FXML
    private Button updateBookButton;





    @FXML
    void addBook(ActionEvent event) {
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String branchName = BookBranchField.getText();


        Branch branch = fetchBranchByName(branchName);

        if (branch != null) {

            Book book = new Book(title, true, author, genre);
            book.setBranch(branch);

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            try {
                session.persist(book);
                transaction.commit();
                System.out.println("Book added successfully!");
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                System.err.println("Failed to add book.");
            } finally {
                session.close();
            }
        } else {
            System.err.println("Branch with name '" + branchName + "' not found.");
        }
    }

    @FXML
    void addBranch(ActionEvent event) {
        String branchName = branchField.getText();

        if (branchName != null && !branchName.trim().isEmpty()) {
            try {
                Session session = SessionFactoryConfiguration.getInstance().getSession();
                Transaction transaction = session.beginTransaction();


                Branch existingBranch = (Branch) session.createQuery("FROM Branch WHERE branch = :branchName")
                        .setParameter("branchName", branchName)
                        .uniqueResult();

                if (existingBranch == null) {

                    Branch branch = new Branch();
                    branch.setBranch(branchName);


                    session.persist(branch);

                    transaction.commit();
                    System.out.println("Branch added successfully.");
                } else {
                    System.out.println("Branch already exists.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please enter a valid branch name.");
        }
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void removeBook(ActionEvent event) {
        // Get input value from text field
        String title = titleField.getText();

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Retrieve the book entity to remove
            Query<Book> query = session.createQuery("FROM Book WHERE bookName = :title", Book.class);
            query.setParameter("title", title);
            Book book = query.uniqueResult();

            if (book != null) {
                // Remove associated references
                book.getBranch().getBookList().remove(book);
                session.delete(book);
                transaction.commit();
                System.out.println("Book removed successfully!");
            } else {
                System.err.println("Book with title '" + title + "' not found.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            System.err.println("Failed to remove book.");
        } finally {
            session.close();
        }
    }

    @FXML
    void removeBranch(ActionEvent event) {

        String branchName = branchField.getText();

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Branch> query = session.createQuery("FROM Branch WHERE branch = :branchName", Branch.class);
        query.setParameter("branchName", branchName);
        Branch branch = query.uniqueResult();

        if (branch != null) {

            session.remove(branch);
            transaction.commit();

            System.out.println("Branch removed successfully: " + branchName);
        } else {

            System.out.println("No branch found with the name: " + branchName);
        }

        session.close();
    }

    @FXML
    void updateBookDetails(ActionEvent event) {

        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String branchName = BookBranchField.getText();


        Branch branch = fetchBranchByName(branchName);

        if (branch != null) {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            try {

                Query<Book> query = session.createQuery("FROM Book WHERE bookName = :title", Book.class);
                query.setParameter("title", title);
                Book book = query.uniqueResult();

                if (book != null) {

                    book.setAuthor(author);
                    book.setGenre(genre);
                    book.setBranch(branch);

                    session.merge(book);
                    transaction.commit();
                    System.out.println("Book details updated successfully!");
                } else {
                    System.err.println("Book with title '" + title + "' not found.");
                }
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                System.err.println("Failed to update book details.");
            } finally {
                session.close();
            }
        } else {
            System.err.println("Branch with name '" + branchName + "' not found.");
        }
    }

    @FXML
    void visitBookManager(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/book_returns.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @FXML
    void visitDashboard(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard_form.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @FXML
    void visitMyProfile(ActionEvent event) {

    }

    private Branch fetchBranchByName(String branchName) {
        try (Session session = SessionFactoryConfiguration.getInstance().getSession()) {
            Query<Branch> query = session.createQuery("FROM Branch WHERE branch = :branchName", Branch.class);
            query.setParameter("branchName", branchName);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
