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
import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

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





    @FXML
    void login(ActionEvent event) throws IOException {
        if (loginManager(userNameField.getText(),passwordFiled.getText())) {
            Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
            Stage window = (Stage) signupButton.getScene().getWindow();
            window.setScene(new Scene(rootNode, 1200,800));
        }
        else {
            showAlert("Incorrect", "Incorrect Credentials\nPlease try again");
        }
    }

    @FXML
    void signup(MouseEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/signup_form.fxml"));
        Stage window = (Stage) signupButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    private boolean loginManager(String userName, String password) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        String hql = "FROM User u WHERE u.userName = :inputUserName AND u.password = :inputPassword";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("inputUserName", userName);
        query.setParameter("inputPassword", password);

        User user = query.uniqueResult();
        boolean isAuthenticated = (user != null);

        session.close();
        return isAuthenticated;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
