package com.company;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.model.Course;
import com.company.services.AdministratorService;
import com.company.services.impl.AdministratorServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CourseView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOk;

    @FXML
    private TextField txtNameCourse;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtDuration;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnOk)){
            addCourse();
        }else {
            btnCancel.getScene().getWindow().hide();
        }
    }

    private void addCourse() {
        String name = txtNameCourse.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int duration = Integer.parseInt(txtDuration.getText());

        Course course = new Course(name, price, duration);
        AdministratorService service = new AdministratorServiceImpl();
        service.createCourser(course);
        btnOk.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'CourseView.fxml'.";
        assert txtNameCourse != null : "fx:id=\"txtNameCourse\" was not injected: check your FXML file 'CourseView.fxml'.";
        assert txtPrice != null : "fx:id=\"txtPrice\" was not injected: check your FXML file 'CourseView.fxml'.";
        assert txtDuration != null : "fx:id=\"txtDuration\" was not injected: check your FXML file 'CourseView.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'CourseView.fxml'.";

    }
}
