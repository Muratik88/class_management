package com.company;

import com.company.model.User;
import com.company.services.AdministratorService;
import com.company.services.impl.AdministratorServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class UserView {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnEnter;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(btnEnter)){
            addUser();
        }else{
            btnCancel.getScene().getWindow().hide();
        }

    }

    private void addUser() {
        String login = txtLogin.getText();
        String password = txtPassword.getText();

        if (login.isEmpty() || password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Заполните поля!",ButtonType.OK);
            alert.show();
            return;
        }

        User user = new User(login, password);
        AdministratorService service = new AdministratorServiceImpl();
        service.createUser(user);
        btnEnter.getScene().getWindow().hide();
    }

}
