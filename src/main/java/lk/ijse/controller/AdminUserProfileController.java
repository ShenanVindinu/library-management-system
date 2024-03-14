package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.bo.custom.AdminUserProfileBO;
import lk.ijse.bo.custom.impl.AdminUserProfileBOImpl;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

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

    AdminUserProfileBO adminUserProfileBOImpl = new AdminUserProfileBOImpl();





    @FXML
    void addBook(ActionEvent event) {
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String branchName = BookBranchField.getText();

        Branch branch = adminUserProfileBOImpl.getBranchByName(branchName);

        if (branch != null) {
            Book book = new Book(title, true, author, genre);
            book.setBranch(branch);
            adminUserProfileBOImpl.saveBookToTable(book);
            System.out.println("Book added successfully!");
        } else {
            System.err.println("Branch with name '" + branchName + "' not found.");
        }
    }

    @FXML
    void addBranch(ActionEvent event) {
        String branchName = branchField.getText();

        if (branchName != null && !branchName.trim().isEmpty()) {

            Branch existingBranch = adminUserProfileBOImpl.getBranchByName(branchName);

            if (existingBranch == null) {
                Branch branch = new Branch();
                branch.setBranch(branchName);
                adminUserProfileBOImpl.savingBranchToTable(branch);
                System.out.println("Branch added successfully.");
            } else {
                System.out.println("Branch already exists.");
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

        String title = titleField.getText();

        Book book = adminUserProfileBOImpl.findBookByName(title);

        if (book != null) {
            adminUserProfileBOImpl.removingAssociatedReferences(book);
            System.out.println("Book removed successfully!");
        } else {
            System.err.println("Book with title '" + title + "' not found.");
        }

    }

    @FXML
    void removeBranch(ActionEvent event) {

        String branchName = branchField.getText();

        Branch branch = adminUserProfileBOImpl.getBranchByName(branchName);

        if (branch != null) {

            adminUserProfileBOImpl.removeBranches(branch);

            System.out.println("Branch removed successfully: " + branchName);
        } else {

            System.out.println("No branch found with the name: " + branchName);
        }
    }

    @FXML
    void updateBookDetails(ActionEvent event) {

        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String branchName = BookBranchField.getText();


        Branch branch = adminUserProfileBOImpl.getBranchByName(branchName);

        if (branch != null) {
            Book book = adminUserProfileBOImpl.findBookByName(title);
            if (book != null) {
                adminUserProfileBOImpl.updateBookDetails(book,author,genre,branch);
                System.out.println("Book details updated successfully!");
            } else {
                System.err.println("Book with title '" + title + "' not found.");
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

}
