package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserProfileForm {

    @FXML
    private Button LogoutButton;

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableView<?> bookTable;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private Button returnBookButton;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private TextField titleField;

    @FXML
    private Button userDetailsButton;

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void returnBook(ActionEvent event) {

    }

    @FXML
    void visitDashboard(ActionEvent event) {

    }

    @FXML
    void visitMyProfile(ActionEvent event) {

    }

    @FXML
    void visitUserDetails(ActionEvent event) {

    }

}
