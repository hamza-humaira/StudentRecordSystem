package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        DataStore.loadFromCSV();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
        BorderPane root = loader.load();

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setTitle("Student Record System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
