package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    void logout(ActionEvent event) {

    }

    @FXML
    void searchBook(ActionEvent event) {

    }

    @FXML
    void visitAdminControlls(ActionEvent event) {

    }

    @FXML
    void visitDashboard(ActionEvent event) {

    }

}
