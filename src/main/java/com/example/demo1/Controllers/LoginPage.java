package com.example.demo1.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.Database.DBHelper;
import com.example.demo1.Session.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class LoginPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Log_Foget_P;

    @FXML
    private Button Log_Login_B;

    @FXML
    private Label Log_output;

    @FXML
    private PasswordField Log_Password;

    @FXML
    private TextField Log_UserName;

    @FXML
    private Label Log_reg;

    @FXML
    private TextField Log_Password_Visible;

    @FXML
    private CheckBox showPasswordCheckBox;



    @FXML
    void Log_Foget_P_Click(MouseEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/FPassword-Page.fxml"));
            Scene scene = Log_Login_B.getScene();
            scene.setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Log_Login_B_click(MouseEvent event) {
        String username = Log_UserName.getText().trim();
        String password = Log_Password.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Log_output.setText("Please enter both username and password!");
            return;
        }

        boolean success = DBHelper.loginUser(username, password);

        if (success) {
            Log_output.setText("Login successful! Welcome " + username);

            UserSession.setUsername(username);
            try {
                Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home-Page.fxml"));
                Scene scene = Log_Login_B.getScene();
                scene.setRoot(newRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log_UserName.clear();
            Log_Password.clear();

        } else {
            Log_output.setText("Invalid username or password!");
        }
    }


    @FXML
    void Log_reg_Click(MouseEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Singup-Page.fxml"));
            Scene scene = Log_reg.getScene();
            scene.setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        Log_Password_Visible.managedProperty().bind(showPasswordCheckBox.selectedProperty());
        Log_Password_Visible.visibleProperty().bind(showPasswordCheckBox.selectedProperty());
        Log_Password.managedProperty().bind(showPasswordCheckBox.selectedProperty().not());
        Log_Password.visibleProperty().bind(showPasswordCheckBox.selectedProperty().not());
        Log_Password_Visible.textProperty().bindBidirectional(Log_Password.textProperty());
    }

}
