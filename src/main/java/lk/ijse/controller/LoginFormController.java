package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.bo.custom.LoginBO;
import lk.ijse.bo.custom.impl.LoginBOImpl;
import lk.ijse.entity.User;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField userNameField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordFiled;

    @FXML
    private Text signupButton;

    LoginBO loginBO = new LoginBOImpl();





    @FXML
    void login(ActionEvent event) throws IOException {

        if (userNameField.getText().equals("Admin")&passwordFiled.getText().equals("admin123")){
            showAlert2("Welcome "+userNameField.getText());
            Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard_form.fxml"));
            Stage window = (Stage) signupButton.getScene().getWindow();
            window.setScene(new Scene(rootNode, 1200,800));
            return;
        }

        if (loginManager(userNameField.getText(),passwordFiled.getText())) {

                showAlert2("Welcome "+userNameField.getText());
                Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard_form.fxml"));
                Stage window = (Stage) signupButton.getScene().getWindow();
                window.setScene(new Scene(rootNode, 1200,800));

        }
        else {
            showAlert();
        }
    }

    @FXML
    void signup(MouseEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/signup_form.fxml"));
        Stage window = (Stage) signupButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    public static String sendUserName;

    private boolean loginManager(String userName, String password) {
        User user = loginBO.signIn(userName, password);
        if (user==null) {
            return false;
        }
        sendUserName = user.getUserName();
        return (user != null);
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect");
        alert.setHeaderText(null);
        alert.setContentText("Incorrect Credentials\nPlease try again");
        alert.showAndWait();
    }

    private void showAlert2(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Correct");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
