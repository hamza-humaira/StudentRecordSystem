package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.Node;

import java.io.IOException;

public class MainController {

    // ------------------------
    // FXML-injected buttons
    // ------------------------
    @FXML private Button btnDashboard;
    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;
    @FXML private Button btnViewAll;
    @FXML private Button btnSearch;

    // Center content area
    @FXML private AnchorPane mainContent;

    // ------------------------
    // Initialize method
    // ------------------------
    @FXML
    public void initialize() {
        System.out.println("Controller initialized");
        // No need for setOnAction here because FXML handles button actions
    }

    // ------------------------
    // Button handlers
    // ------------------------
    @FXML
    private void handleDashboard() {
        loadView("dashboard.fxml");
    }

    @FXML
    private void handleAdd() {
        loadView("add_student.fxml");
    }

    @FXML
    private void handleUpdate() {
        loadView("update_student.fxml");
    }

    @FXML
    private void handleDelete() {
        loadView("delete_student.fxml");
    }

    @FXML
    private void handleViewAll() {
        loadView("view_all.fxml");
    }

    @FXML
    private void handleSearch() {
        loadView("search.fxml");
    }

    // ------------------------
    // Utility method to load FXML into center AnchorPane
    // ------------------------
    private void loadView(String fxmlFile) {
        try {
            Node node = FXMLLoader.load(getClass().getResource("/view/" + fxmlFile));
            mainContent.getChildren().setAll(node);

            // Make the node fill the AnchorPane
            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
