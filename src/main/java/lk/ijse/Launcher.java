package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(rootNode, 800, 650);

        Image stageIcon  =  new Image("asset/icon/icons8-book-64.png");
        stage.getIcons().add(stageIcon);

        stage.setTitle("BookWorm");
        stage.setScene(scene);
        stage.centerOnScreen();

        stage.show();
    }
}