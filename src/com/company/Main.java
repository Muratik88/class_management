package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("courseView.fxml"));
//        primaryStage.setTitle("Создание курса");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

//        Parent root = FXMLLoader.load(getClass().getResource("teacherView.fxml"));
//        primaryStage.setTitle("Регистрация учителя");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

        Parent root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        primaryStage.setTitle("Авторизация");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
