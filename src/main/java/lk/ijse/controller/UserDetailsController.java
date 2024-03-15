package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.bo.custom.AdminUserProfileBO;
import lk.ijse.bo.custom.SignupBO;
import lk.ijse.bo.custom.impl.AdminUserProfileBOImpl;
import lk.ijse.bo.custom.impl.SignupBOImpl;
import lk.ijse.entity.User;

import java.io.IOException;

public class UserDetailsController {

    @FXML
    private Button LogoutButton;

    @FXML
    private Button backButton;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button updateButton;

    AdminUserProfileBO adminUserProfileBO = new AdminUserProfileBOImpl();
    SignupBO signupBO = new SignupBOImpl();

    @FXML
    void backToBookHistory(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_profile_form.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void updateUserDetails(ActionEvent event) {

        String username = usernameField.getText();
        String password = passwordField.getText();


        User user = adminUserProfileBO.findUserByUsername(username);

        if (user != null) {
            signupBO.updateUser(user,password);
            System.out.println("User details updated successfully!");

        } else {
            System.err.println("User with username '" + username + "' not found.");
        }
    }

    @FXML
    void visitDashboard(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard_form.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @FXML
    void visitMyProfile(ActionEvent event) {

    }

}
