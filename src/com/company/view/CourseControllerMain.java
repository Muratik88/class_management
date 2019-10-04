package com.company.view;

import com.company.model.Course;
import com.company.services.AdministratorService;
import com.company.services.DbService;
import com.company.services.impl.AdministratorServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseControllerMain {

    @FXML
    private MenuItem menuItemAdd;

    @FXML
    private MenuItem menuItemEdit;

    @FXML
    private MenuItem menuItemDelete;

    @FXML
    private TableView<Course> tblCourses;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        refreshTable();
    }

    private void refreshTable() {
        AdministratorService service = new AdministratorServiceImpl();
        List<Course> list = service.getCoursesList();
        ObservableList<Course> observableList = FXCollections.observableList(list);
        tblCourses.setItems(observableList);
    }

    @FXML
    void onMenuItemAction(ActionEvent event) {
        if (event.getSource().equals(menuItemAdd)){
            saveCourse();
        }else if (event.getSource().equals(menuItemEdit)){
            updateCourse();
        }else if (event.getSource().equals(menuItemDelete)){
            deleteCourse();
        }
    }

    private void deleteCourse() {
        AdministratorService service = new AdministratorServiceImpl();
        Course course = tblCourses.getSelectionModel().getSelectedItem();
        service.deleteCourse(course.getId_course());
        refreshTable();
    }

    private void updateCourse() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("courseView.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            Course course = tblCourses.getSelectionModel().getSelectedItem();
            CourseController courseController = loader.getController();
            courseController.initData(course);
            stage.show();
            stage.setOnCloseRequest(event -> refreshTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCourse() {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("courseView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Добавление курсов");
            stage.show();
            stage.setOnCloseRequest(event1 -> refreshTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
