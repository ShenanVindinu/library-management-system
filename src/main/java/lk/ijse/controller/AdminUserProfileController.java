package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminUserProfileController {

    @FXML
    private Button LogoutButton;

    @FXML
    private Button addBookButton;

    @FXML
    private Button addBranchButton;

    @FXML
    private TextField authorField;

    @FXML
    private Button boolManagerButton;

    @FXML
    private TextField branchField;

    @FXML
    private Button dashboardButton;

    @FXML
    private TextField genreField;

    @FXML
    private Button myProfileButton;

    @FXML
    private Button removeBookButton;

    @FXML
    private Button removeBranchButton;

    @FXML
    private TextField titleField;

    @FXML
    private Button updateBookButton;

    @FXML
    private TextField BookBranchField;



    @FXML
    void addBook(ActionEvent event) {

    }

    @FXML
    void addBranch(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void removeBook(ActionEvent event) {

    }

    @FXML
    void removeBranch(ActionEvent event) {

    }

    @FXML
    void updateBookDetails(ActionEvent event) {

    }

    @FXML
    void visitBookManager(ActionEvent event) {

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
