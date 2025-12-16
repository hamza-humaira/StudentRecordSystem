package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.DataStore;
import model.Student;

public class AddStudentController {

    @FXML private TextField txtName;
    @FXML private TextField txtId;
    @FXML private ComboBox<String> comboDepartment;
    @FXML private TextField txtEmail;
    @FXML private TextField txtCgpa;
    @FXML private Button btnSave;

    @FXML
    public void initialize() {
        comboDepartment.getItems().addAll(
                "CSE", "EEE", "BBA", "ENG", "LAW"
        );
    }

    @FXML
    private void saveStudent() {
        String name = txtName.getText();
        String id = txtId.getText();
        String dept = comboDepartment.getValue();

        if (dept == null) {
            System.out.println("Please select a department!");
            return;
        }

        String email = txtEmail.getText();
        String cgpaText = txtCgpa.getText();

        double cgpa;
        try {
            cgpa = Double.parseDouble(cgpaText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid CGPA!");
            return;
        }

        Student student = new Student(name, id, dept, email, cgpa);
        DataStore.addStudent(student);

        System.out.println("Student saved! Total students: "
                + DataStore.getStudents().size());

        txtName.clear();
        txtId.clear();
        txtEmail.clear();
        txtCgpa.clear();
        comboDepartment.getSelectionModel().clearSelection();
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }
}
