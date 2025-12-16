package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataStore;
import model.Student;

public class ViewAllController {

    @FXML
    private TableView<Student> tableStudents;

    @FXML
    private TableColumn <Student, String> colName;

    @FXML
    private  TableColumn <Student, String> colId;

    @FXML
    private TableColumn <Student, String> colDept;

    @FXML
    private TableColumn <Student, String> colEmail;

    @FXML
    private TableColumn <Student, String> colCgpa;

    @FXML
    public void initialize() {
        // Connect table columns with Student properties
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDept.setCellValueFactory(new PropertyValueFactory<>("department"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCgpa.setCellValueFactory(new PropertyValueFactory<>("cgpa"));

        // Load student data from your list
        tableStudents.getItems().setAll(DataStore.getStudents());
    }

}
