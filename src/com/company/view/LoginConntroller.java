package com.company.view;

import com.company.services.AdministratorService;
import com.company.services.impl.AdministratorServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jdk.nashorn.api.tree.IfTree;

import java.io.IOException;

public class LoginConntroller {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnEnter;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnEnter)){
            login();
        } else if (event.getSource().equals(btnCancel)){
            btnCancel.getScene().getWindow().hide();
        }
    }

    private void login() {
        String login = txtLogin.getText();
        String password = txtPassword.getText();

        if (login.isEmpty() || password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Заполните поля!", ButtonType.OK);
            alert.show();
            return;
        }
        AdministratorService service = new AdministratorServiceImpl();
        if (service.checkCredentials(login, password)){
            Stage stage = new Stage();
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("mainView.fxml"));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Главное окно");
                stage.show();
                btnCancel.getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Неверный логин или пароль!", ButtonType.OK);
            alert.show();
        }
    }
}
