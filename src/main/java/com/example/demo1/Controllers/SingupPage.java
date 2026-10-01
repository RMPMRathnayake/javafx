package com.example.demo1.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import com.example.demo1.Database.DBHelper;


public class SingupPage {

    @FXML
    public CheckBox PasswordCheckBox;

    @FXML
    public TextField Password_Visible;

    @FXML
    public CheckBox Com_PasswordCheckBox;

    @FXML
    public TextField Com_Password_Visible;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Reg_Email;

    @FXML
    private TextField Reg_First_Name;

    @FXML
    private TextField Reg_Last_Name;

    @FXML
    private Label Reg_Log;

    @FXML
    private Label Reg_Output;

    @FXML
    private PasswordField Reg_Password;

    @FXML
    private PasswordField Reg_RePassword;

    @FXML
    private Button Reg_Sinup_B;

    @FXML
    private TextField Reg_UserName;



    @FXML
    void Reg_Log_Click(MouseEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Login-Page.fxml"));
            Scene scene = Reg_Log.getScene();
            scene.setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Reg_Sinup_B_click(MouseEvent event) {

        String password = Reg_Password.getText();
        String repassword = Reg_RePassword.getText();
        String username = Reg_UserName.getText();
        String FirstName = Reg_First_Name.getText();
        String LastName = Reg_Last_Name.getText();
        String Email = Reg_Email.getText();

        if (FirstName.isEmpty() || LastName.isEmpty() || username.isEmpty()
                || Email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            Reg_Output.setText("Enter All Fields!");
            return;
        }

        if (!Email.contains("@gmail.com")) {
            Reg_Output.setText("Enter Valid Email Address!");
            return;
        }

        if (!password.equals(repassword)) {
            Reg_Output.setText("Passwords do not match!");
            return;
        }

        boolean success = DBHelper.registerUser(
                FirstName, LastName, username, Email, password
        );

        if (success) {
            Reg_Output.setText("Registration Successful!");

            try {
                Parent newRoot = FXMLLoader.load(
                        getClass().getResource("/com/example/demo1/Login-Page.fxml"));
                Scene scene = Reg_Log.getScene();
                scene.setRoot(newRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Reg_Output.setText("Username or Email already exists!");
        }
    }

    @FXML
    void initialize() {
        Password_Visible.managedProperty().bind(PasswordCheckBox.selectedProperty());
        Password_Visible.visibleProperty().bind(PasswordCheckBox.selectedProperty());
        Reg_Password.managedProperty().bind(PasswordCheckBox.selectedProperty().not());
        Reg_Password.visibleProperty().bind(PasswordCheckBox.selectedProperty().not());
        Password_Visible.textProperty().bindBidirectional(Reg_Password.textProperty());

        Com_Password_Visible.managedProperty().bind(Com_PasswordCheckBox.selectedProperty());
        Com_Password_Visible.visibleProperty().bind(Com_PasswordCheckBox.selectedProperty());
        Reg_Password.managedProperty().bind(Com_PasswordCheckBox.selectedProperty().not());
        Reg_RePassword.visibleProperty().bind(Com_PasswordCheckBox.selectedProperty().not());
        Com_Password_Visible.textProperty().bindBidirectional(Reg_RePassword.textProperty());
    }

}
