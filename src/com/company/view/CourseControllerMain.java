package com.company.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseControllerMain {

    @FXML
    private MenuItem menuAddCourse;

    @FXML
    private MenuItem menuEditCourse;

    @FXML
    private MenuItem menuDeleteCourse;

    @FXML
    private TableView<?> tblCourses;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    void onDeleteAction(ActionEvent event) {

    }

    @FXML
    void onEditAction(ActionEvent event) {

    }

    @FXML
    void initialize() {


    }


    @FXML
    void onAddAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("courseView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Добавление курсов");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
