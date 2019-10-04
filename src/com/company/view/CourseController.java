package com.company.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.model.Course;
import com.company.services.AdministratorService;
import com.company.services.impl.AdministratorServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CourseController {

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

    private Course course;
    private boolean checkInit;

    public void initData(Course course){
        this.course = course;
        txtNameCourse.setText(course.getName());
        txtPrice.setText(String.valueOf(course.getPrice()));
        txtDuration.setText(String.valueOf(course.getDuration()));
        checkInit = true;
    }
    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnOk)){
            addCourse();
            Stage stage = (Stage)(btnOk.getScene().getWindow());
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        }else {
            btnCancel.getScene().getWindow().hide();
        }
    }

    private void addCourse() {
        String name = txtNameCourse.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int duration = Integer.parseInt(txtDuration.getText());

        if (checkInit){
            course.setName(name);
            course.setPrice(price);
            course.setDuration(duration);
            AdministratorService service = new AdministratorServiceImpl();
            service.updateCourse(course);
        }else{
            Course course = new Course(name, price, duration);
            AdministratorService service = new AdministratorServiceImpl();
            service.createCourse(course);
        }

    }

    @FXML
    void initialize() {
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'CourseController.fxml'.";
        assert txtNameCourse != null : "fx:id=\"txtNameCourse\" was not injected: check your FXML file 'CourseController.fxml'.";
        assert txtPrice != null : "fx:id=\"txtPrice\" was not injected: check your FXML file 'CourseController.fxml'.";
        assert txtDuration != null : "fx:id=\"txtDuration\" was not injected: check your FXML file 'CourseController.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'CourseController.fxml'.";

    }
}
