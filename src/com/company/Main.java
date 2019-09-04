package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        //        AdministratorService service = new AdministratorServiceImpl();
//        Course course = new Course("English",1000,3);
//        service.createCourse(course);

//        Teacher teacher = new Teacher("Жылдыз", "9965515544330","ул.Ленина 15", null);
//        service.createTeacher(teacher);

//        Group group = new Group(1,1, new Date());
//        service.createGroup(group);

//        Student student = new Student("Чынгыз", "996332211","ул.Месароша 123",null);
//        service.createStudent(student);
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

        Parent root = FXMLLoader.load(getClass().getResource("studentView.fxml"));
        primaryStage.setTitle("Регистрация студента");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }
}
