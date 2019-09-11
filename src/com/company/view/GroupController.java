package com.company.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.company.model.Course;
import com.company.model.Group;
import com.company.model.Teacher;
import com.company.services.AdministratorService;
import com.company.services.DbService;
import com.company.services.impl.AdministratorServiceImpl;
import com.company.services.impl.DbServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class GroupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker dpStart;

    @FXML
    private ComboBox<Teacher> cmbTeachers;

    @FXML
    private ComboBox<Course> cmbCourse;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void onSaveGroup(ActionEvent event) {
        if (event.getSource().equals(btnSave)){
            Teacher teacher = cmbTeachers.getSelectionModel().getSelectedItem();
            Course course = cmbCourse.getSelectionModel().getSelectedItem();

            System.out.println(teacher.getId());
            System.out.println(course.getId_course());


            Group group = new Group(course.getId_course(), teacher.getId(), dpStart.getValue());
            AdministratorService service = new AdministratorServiceImpl();
            service.createGroup(group);
            btnCancel.getScene().getWindow().hide();

        }else if (event.getSource().equals(btnCancel)){
            btnCancel.getScene().getWindow().hide();
        }
    }

    @FXML
    void initialize() {
        assert dpStart != null : "fx:id=\"dpStart\" was not injected: check your FXML file 'groupView.fxml'.";
        assert cmbTeachers != null : "fx:id=\"cmbTeachers\" was not injected: check your FXML file 'groupView.fxml'.";
        assert cmbCourse != null : "fx:id=\"cmbCourse\" was not injected: check your FXML file 'groupView.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'groupView.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'groupView.fxml'.";


        AdministratorService service = new AdministratorServiceImpl();
        List<Teacher> list = service.getTeacherList();

        ObservableList<Teacher> observableList = FXCollections.observableArrayList(list);
        cmbTeachers.setItems(observableList);


        List<Course> list1 = service.getCoursesList();
        ObservableList<Course> observableList1 = FXCollections.observableArrayList(list1);
        cmbCourse.setItems(observableList1);
    }
}
