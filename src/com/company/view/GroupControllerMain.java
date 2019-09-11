package com.company.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class GroupControllerMain {

    @FXML
    private MenuItem menuAddGroup;

    @FXML
    private MenuItem menuEditGroup;

    @FXML
    private MenuItem menuDeleteGroup;

    @FXML
    void onAddAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("groupView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Группы");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onDeleteAction(ActionEvent event) {

    }

    @FXML
    void onEditAction(ActionEvent event) {

    }

}
