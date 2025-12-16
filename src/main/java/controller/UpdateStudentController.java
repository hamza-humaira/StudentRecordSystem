package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DataStore;
import model.Student;

public class UpdateStudentController {


    @FXML private TextField txtSearchId;
    @FXML private Button btnSearch;

    @FXML private TextField txtName;
    @FXML private TextField txtId;
    @FXML private TextField txtDept;
    @FXML private TextField txtEmail;
    @FXML private TextField txtCgpa;
    @FXML private Button btnUpdate;

    private Student currentStudent;

    @FXML
    private void searchStudent() {
        String id = txtSearchId.getText();
        currentStudent = null;
        for (Student s: DataStore.getStudents())
        {
            if (s.getId().equals(id))
            {
                currentStudent = s;
                break;
            }
        }

        if (currentStudent != null) {
            txtName.setText(currentStudent.getName());
            txtId.setText(currentStudent.getId());
            txtDept.setText(currentStudent.getDepartment());
            txtEmail.setText(currentStudent.getEmail());
            txtCgpa.setText(String.valueOf(currentStudent.getCgpa()));
            System.out.println("Student found!");
        } else {
            System.out.println("Student not found!");
        }
    }

    @FXML
    private void updateStudent() {
        if (currentStudent == null) {
            System.out.println("No student selected!");
            return;
        }

        currentStudent.setName(txtName.getText());
        currentStudent.setId(txtId.getText());
        currentStudent.setDepartment(txtDept.getText());
        currentStudent.setEmail(txtEmail.getText());
        try {
            currentStudent.setCgpa(Double.parseDouble(txtCgpa.getText()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid CGPA!");
            return;
        }

        System.out.println("Student updated: " + currentStudent);

        // Clear the form
        txtName.clear();
        txtId.clear();
        txtDept.clear();
        txtEmail.clear();
        txtCgpa.clear();
        txtSearchId.clear();


        System.out.println("Student saved! Total students: " + DataStore.getStudents().size());
    }



}
