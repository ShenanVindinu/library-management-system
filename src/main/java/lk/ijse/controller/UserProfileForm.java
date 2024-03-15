package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.custom.impl.UserProfileBOImpl;
import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.BookHistory;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserProfileForm implements Initializable {

    @FXML
    private Button LogoutButton;

    @FXML
    private TableColumn<?, ?> DueDateColumn;

    @FXML
    private TableView<BookHistory> bookTable;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private TableColumn<?, ?> bookNameColumn;

    @FXML
    private TableColumn<?, ?> returnStatusColumn;

    @FXML
    private Button userDetailsButton;

    UserProfileBOImpl userProfileBO = new UserProfileBOImpl();

    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
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

    @FXML
    void visitUserDetails(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_details.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String currentUser = LoginFormController.sendUserName;
        Query<BookHistory> query = session.createQuery(
                "SELECT b " +
                        "FROM BookHistory b " +
                        "WHERE b.user.userName = :userName",
                BookHistory.class
        );
        query.setParameter("userName", currentUser);
        List<BookHistory> results = query.list();
        ObservableList<BookHistory> data = FXCollections.observableArrayList(results);

        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        returnStatusColumn.setCellValueFactory(new PropertyValueFactory<>("returned"));

        bookTable.setItems(data);

        transaction.commit();
        session.close();

        bookTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                BookHistory selectedBook = newSelection;
                selectedBook.setReturned(true);

                userProfileBO.updateBookHistory(selectedBook);
                System.out.println("Book added to history: " + selectedBook);
            }
        });
    }
}
