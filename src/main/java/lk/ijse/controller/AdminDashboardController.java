package lk.ijse.controller;

import javafx.beans.property.SimpleStringProperty;
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
import lk.ijse.bo.custom.AdminUserProfileBO;
import lk.ijse.bo.custom.impl.AdminUserProfileBOImpl;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminDashboardController {

    @FXML
    private Button AdminProfileButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button dashboardButton;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

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

    AdminUserProfileBO adminUserProfileBO = new AdminUserProfileBOImpl();



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
    void visitAdminControlls(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_user_profile_form.fxml"));
        Stage window = (Stage) AdminProfileButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
    }

    @FXML
    void visitDashboard(ActionEvent event) throws IOException {
        //no need to specify anything
        //this was added by a mistake
        // I'm lazy to remove it now.
    }
}
