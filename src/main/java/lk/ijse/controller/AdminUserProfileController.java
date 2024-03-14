package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;

public class AdminUserProfileController {

    @FXML
    private Button LogoutButton;

    @FXML
    private Button addBookButton;

    @FXML
    private Button addBranchButton;

    @FXML
    private TextField authorField;

    @FXML
    private Button boolManagerButton;

    @FXML
    private TextField branchField;

    @FXML
    private Button dashboardButton;

    @FXML
    private TextField genreField;

    @FXML
    private Button myProfileButton;

    @FXML
    private Button removeBookButton;

    @FXML
    private Button removeBranchButton;

    @FXML
    private TextField titleField;

    @FXML
    private Button updateBookButton;

    @FXML
    private TextField BookBranchField;



    @FXML
    void addBook(ActionEvent event) {

    }

    @FXML
    void addBranch(ActionEvent event) {
        String branchName = branchField.getText();

        if (branchName != null && !branchName.trim().isEmpty()) {
            try {
                Session session = SessionFactoryConfiguration.getInstance().getSession();
                Transaction transaction = session.beginTransaction();


                Branch existingBranch = (Branch) session.createQuery("FROM Branch WHERE branch = :branchName")
                        .setParameter("branchName", branchName)
                        .uniqueResult();

                if (existingBranch == null) {

                    Branch branch = new Branch();
                    branch.setBranch(branchName);


                    session.persist(branch);

                    transaction.commit();
                    System.out.println("Branch added successfully.");
                } else {
                    System.out.println("Branch already exists.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please enter a valid branch name.");
        }
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Stage window = (Stage) LogoutButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 800,600));
    }

    @FXML
    void removeBook(ActionEvent event) {

    }

    @FXML
    void removeBranch(ActionEvent event) {

        String branchName = branchField.getText();

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Branch> query = session.createQuery("FROM Branch WHERE branch = :branchName", Branch.class);
        query.setParameter("branchName", branchName);
        Branch branch = query.uniqueResult();

        if (branch != null) {

            session.remove(branch);
            transaction.commit();

            System.out.println("Branch removed successfully: " + branchName);
        } else {

            System.out.println("No branch found with the name: " + branchName);
        }

        session.close();
    }

    @FXML
    void updateBookDetails(ActionEvent event) {

    }

    @FXML
    void visitBookManager(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/book_returns.fxml"));
        Stage window = (Stage) dashboardButton.getScene().getWindow();
        window.setScene(new Scene(rootNode, 1200,800));
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

}
