package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.bo.custom.SignupBO;
import lk.ijse.bo.custom.impl.SignupBOImpl;
import lk.ijse.entity.User;

import java.io.IOException;

public class SignupFormController {

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

    SignupBO signupBO = new SignupBOImpl();

    @FXML
    void BackToLogin(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) signupButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void signup(ActionEvent event) {

        String usernameText = username.getText();
        String nameText = name.getText();
        String passwordText = passwordFiled.getText();
        String emailText = email.getText();

        if (!validateName(nameText)) {
            showAlert("Invalid name", "name should only contain letters.");
            return;
        }

        if (validateUsername(usernameText)) {
            showAlert("username taken", "This username is already taken. please try another");
        }

        else {
            User user = new User(usernameText, emailText, nameText, passwordText);
            signupBO.saveUser(user);
        }



    }

    private boolean validateName(String Name) {
        String regexPattern = "^[a-zA-Z]+$";
        return Name.matches(regexPattern);
    }

    private boolean validateUsername(String userName) {
        Long value = signupBO.checkIfUserNameExist(userName);
        System.out.println(value);
        return value > 0;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
