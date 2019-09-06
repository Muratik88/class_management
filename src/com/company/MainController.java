package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private MenuItem menuItemClose;

    @FXML
    private MenuItem menuItemCourses;

    @FXML
    private MenuItem menuItemTeachers;

    @FXML
    private MenuItem menuItemStudents;

    @FXML
    private MenuItem menuItemGroups;

    @FXML
    private MenuItem menuItemUsers;

    @FXML
    void menuClose(ActionEvent event) {
    }

    @FXML
    void menuCourses(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("courseView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Курсы");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuGroups(ActionEvent event) {
    }

    @FXML
    void menuStudent(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("studentView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Студенты");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuTeachers(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("teacherView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Учителя");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuUsers(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("userView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Пользователи");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
