package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.entity.User;

import java.io.IOException;

public class SignupFormConroller {

    @FXML
    private Button backButton;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField passwordFiled;

    @FXML
    private Button signupButton;

    @FXML
    private TextField username;

    @FXML
    void BackToLogin(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) signupButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void signup(ActionEvent event) {
        User user = new User(email.getText(), name.getText(), passwordFiled.getText(),username.getText());

    }
}
