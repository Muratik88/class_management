package com.company.view;

import com.company.model.Student;
import com.company.services.AdministratorService;
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
import java.util.List;

public class StudentControllerMain {

    @FXML
    private MenuItem menuItemAdd;

    @FXML
    private MenuItem menuItemEdt;

    @FXML
    private MenuItem menuItemDelete;

    @FXML
    private TableView<Student> tblStudent;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    void onMenuItemAction(ActionEvent event) {
        if (event.getSource().equals(menuItemAdd)){
            saveStudent();
        }else if (event.getSource().equals(menuItemEdt)){
            updateStudent();
        }else if (event.getSource().equals(menuItemDelete)){

        }
    }

    private void updateStudent() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentView.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            Student student = tblStudent.getSelectionModel().getSelectedItem();
            StudentController studentController = loader.getController();
            studentController.initData(student);
            stage.show();
            stage.setOnCloseRequest(event1 -> refreshTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveStudent(){
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("studentView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Дабовления студента");
            stage.show();
            stage.setOnCloseRequest(event1 -> refreshTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));

        refreshTable();
    }

    private void refreshTable() {
        AdministratorService service = new AdministratorServiceImpl();
        List<Student> list = service.getStudentsList();
        ObservableList<Student> observableList = FXCollections.observableList(list);
        tblStudent.setItems(observableList);
    }
}
