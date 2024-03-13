package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Button AdminProfileButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableColumn<?, ?> availabilityColumn;

    @FXML
    private TableView<?> bookTable;

    @FXML
    private TableColumn<?, ?> branchColumn;

    @FXML
    private Button dashboardButton;

    @FXML
    private TableColumn<?, ?> genreColumn;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<?, ?> titleColumn;



    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void searchBook(ActionEvent event) {

    }

    @FXML
    void visitAdminControlls(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_user_profile_form.fxml"));
        Stage window = (Stage) AdminProfileButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @FXML
    void visitDashboard(ActionEvent event) throws IOException {

    }

}
