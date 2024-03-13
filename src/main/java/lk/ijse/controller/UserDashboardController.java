package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserDashboardController {

    @FXML
    private TableView<?> bookTable;

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableColumn<?, ?> availabilityColumn;

    @FXML
    private TableColumn<?, ?> branchColumn;

    @FXML
    private TableColumn<?, ?> genreColumn;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private Button LogoutButton;


    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void searchBook(ActionEvent event) {

    }

    @FXML
    void visitDashboard(ActionEvent event) {

    }

    @FXML
    void visitMyProfile(ActionEvent event) {

    }

}
