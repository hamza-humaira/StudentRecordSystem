package controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.DataStore;
import model.Student;

public class SearchStudentController {

    @FXML
    private TextField txtSearchId;
    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student, String> colName;
    @FXML
    private TableColumn<Student, String> colId;
    @FXML
    private TableColumn<Student, String> colDept;
    @FXML
    private TableColumn<Student, String> colEmail;
    @FXML
    private TableColumn<Student, Double> colCgpa;

    private Student currentStudent;

    @FXML
    public void initialize() {
        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        colDept.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDepartment()));
        colEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
        colCgpa.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCgpa()));
    }

    @FXML
    private void searchStudent() {
        table.getItems().clear();
        String id = txtSearchId.getText();
        currentStudent = null;

        for (Student s : DataStore.getStudents()) {
            if (s.getId().equals(id)) {
                table.getItems().add(s);
                currentStudent = s;
                return;
            }
        }
        System.out.println("Student Found!");
    }
}