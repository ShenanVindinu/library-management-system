package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.custom.AdminUserProfileBO;
import lk.ijse.bo.custom.impl.AdminUserProfileBOImpl;
import lk.ijse.bo.custom.impl.UserProfileBOImpl;
import lk.ijse.dao.custom.LoginDAO;
import lk.ijse.dao.custom.impl.LoginDAOImpl;
import lk.ijse.entity.Book;
import lk.ijse.entity.BookHistory;
import lk.ijse.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserDashboardController {

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableColumn<?, ?> availabilityColumn;

    @FXML
    private TableColumn<Book, String> branchColumn;

    @FXML
    private TableColumn<?, ?> genreColumn;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private Button LogoutButton;


    AdminUserProfileBO adminUserProfileBO = new AdminUserProfileBOImpl();

    UserProfileBOImpl userProfileBO = new UserProfileBOImpl();


    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void searchBook(ActionEvent event) {
        // Get the search criteria from the UI
        String searchTerm = searchBar.getText(); // Assuming you have a TextField named searchField for the search term

        // Perform the search operation
        List<Book> searchResults = adminUserProfileBO.searchBooks(searchTerm);

        // Update the TableView with the search results
        updateBookTable(searchResults);
    }

    // Method to update the TableView with the search results
    private void updateBookTable(List<Book> searchResults) {
        ObservableList<Book> data = FXCollections.observableArrayList(searchResults);

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        branchColumn.setCellValueFactory(new PropertyValueFactory<>("branch")); // Assuming branch has a toString() method that returns its name

        bookTable.setItems(data);
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        bookTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                BookHistory bookHistory = new BookHistory();
                bookHistory.setBookName(newSelection.getBookName());
                bookHistory.setDueDate(java.sql.Date.valueOf(LocalDate.now())); // Using java.sql.Date
                bookHistory.setReturned(false);
                User sendUserName  = new User();
                sendUserName.setUserName(LoginFormController.sendUserName);
                bookHistory.setUser(sendUserName);

                userProfileBO.addToBookHistory(bookHistory);
                System.out.println("Book added to history: " + bookHistory);
            }
        });
    }

    @FXML
    void visitDashboard(ActionEvent event) {

    }

    @FXML
    void visitMyProfile(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_profile_form.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
