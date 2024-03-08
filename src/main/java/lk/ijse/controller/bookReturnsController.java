package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class bookReturnsController {

    @FXML
    private Button LogoutButton;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> bookName;

    @FXML
    private TableView<?> burrowedBooksTable;

    @FXML
    private Button dashboardButton;

    @FXML
    private TableColumn<?, ?> dueDate;

    @FXML
    private Button myProfileButton;

    @FXML
    private TableColumn<?, ?> userName;

    @FXML
    void backToAddBooks(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void visitDashboard(ActionEvent event) {

    }

    @FXML
    void visitMyProfile(ActionEvent event) {

    }

}
