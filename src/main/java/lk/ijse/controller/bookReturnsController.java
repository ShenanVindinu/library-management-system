package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

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
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void visitDashboard(ActionEvent event) {

    }

    @FXML
    void visitMyProfile(ActionEvent event) {

    }

}
