package com.company;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.model.Administrator;
import com.company.model.Course;
import com.company.model.Teacher;
import com.company.services.AdministratorService;
import com.company.services.impl.AdministratorServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TeacherView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAddress;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtSaveClicked(ActionEvent event) {
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();

        Teacher teacher = new Teacher(name, phone, address, null);
        AdministratorService service = new AdministratorServiceImpl();
        service.createTeacher(teacher);
    }

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'teacherView.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'teacherView.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'teacherView.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'teacherView.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'teacherView.fxml'.";

    }
}