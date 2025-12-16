package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private static final String FILE_NAME = "students.csv";
    private static ArrayList<Student> studentList = new ArrayList<>();


    public static void loadFromCSV() {
        studentList.clear();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 5) continue;

                Student student = new Student(
                        data[1],                    // name
                        data[0],                    // id
                        data[2],                    // department
                        data[3],                    // email
                        Double.parseDouble(data[4]) // cgpa
                );

                studentList.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveStudentsToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            bw.write("id,name,department,email,cgpa");
            bw.newLine();

            for (Student s : studentList) {
                bw.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getDepartment() + "," +
                                s.getEmail() + "," +
                                s.getCgpa()
                );
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Student s) {
        studentList.add(s);
        saveStudentsToCSV();
    }


    public static void deleteStudent(Student s) {
        studentList.remove(s);
        saveStudentsToCSV();
    }


    public static List<Student> getStudents() {
        return studentList;
    }
}
