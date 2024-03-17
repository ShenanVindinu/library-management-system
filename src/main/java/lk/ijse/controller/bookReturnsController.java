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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.custom.BookHistoryQueryResult;
import lk.ijse.entity.BookHistory;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class bookReturnsController implements Initializable {

    @FXML
    private Button LogoutButton;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<BookHistory, String> bookName;

    @FXML
    private TableView<BookHistoryQueryResult> burrowedBooksTable;

    @FXML
    private Button dashboardButton;

    @FXML
    private TableColumn<BookHistory, Date> dueDate;

    @FXML
    private Button myProfileButton;

    @FXML
    private TableColumn<User, String> userName;

    @FXML
    void backToAddBooks(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_user_profile_form.fxml"));
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
    void visitDashboard(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard_form.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @FXML
    void visitMyProfile(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<BookHistoryQueryResult> results = session.createQuery(
                "SELECT new lk.ijse.custom.BookHistoryQueryResult(bh.bookName, bh.dueDate, u.userName) " +
                        "FROM BookHistory bh " +
                        "JOIN bh.user u " +
                        "WHERE bh.returned = false",
                BookHistoryQueryResult.class
        ).list();


        ObservableList<BookHistoryQueryResult> data = FXCollections.observableArrayList(results);

        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        userName.setCellValueFactory(new PropertyValueFactory<>("username")); // Note: Property name is "username", not "userName"

        burrowedBooksTable.setItems(data);

        transaction.commit();
        session.close();
    }

}
