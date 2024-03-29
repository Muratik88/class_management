package com.company.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.model.Administrator;
import com.company.model.Student;
import com.company.services.AdministratorService;
import com.company.services.impl.AdministratorServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAddress;

    private Student student;
    private boolean checkInit;

    public void initData(Student student){
        this.student = student;
        txtName.setText(student.getName());
        txtAddress.setText(student.getAddress());
        txtPhone.setText(student.getPhone());
        checkInit = true;
    }

    @FXML
    void onButtSaveClicked(ActionEvent event) {
        if (event.getSource().equals(btnSave)){
            addStudent();
            Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
        }else{
            btnCancel.getScene().getWindow().hide();
        }
    }

    private void addStudent() {
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();

        if (checkInit){
            student.setName(name);
            student.setAddress(address);
            student.setPhone(phone);
//            student = new Student(name, phone, address, null);
            AdministratorService service = new AdministratorServiceImpl();
            service.updateStudent(student);
        }else{
            student = new Student(name, phone, address, null);
            AdministratorService service = new AdministratorServiceImpl();
            service.createStudent(student);
        }
    }

    @FXML
    void initialize() {
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'studentView.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'studentView.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'studentView.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'studentView.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'studentView.fxml'.";
    }
}
