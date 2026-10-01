package com.example.demo1.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.Database.DBHelper;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.demo1.Database.DBHelper.connect;

public class FPasswordPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Pan1_Code_out;

    @FXML
    private Label Pan1_Out;

    @FXML
    private Label Pan2_Out;

    @FXML
    private Label Pan3_Out;

    @FXML
    private TextField Pane1_Email;

    @FXML
    private Button Pane1_Next_B;

    @FXML
    private Button Pane1_Seach_B;

    @FXML
    private Label Pane1_code_lable;

    @FXML
    private Button Pane2_Back_B;

    @FXML
    private TextField Pane2_Code;

    @FXML
    private Button Pane2_Next_B;

    @FXML
    private Button Pane3_Back_B;

    @FXML
    private TextField Pane3_Com_Password;

    @FXML
    private Button Pane3_Next_B;

    @FXML
    private TextField Pane3_Password;

    @FXML
    private Pane Pane_1;

    @FXML
    private Pane Pane_2;

    @FXML
    private Pane Pane_3;

    @FXML
    private TextField Password_Visible;

    @FXML
    private CheckBox PasswordCheckBox;

    @FXML
    private TextField Com_Password_Visible;

    @FXML
    private CheckBox Com_PassworddCheckBox;

    @FXML
    private ImageView Pane1_Back_B;

    private String userEmail;
    private String verificationCode;
    private String newPassword;

    private String generateCode() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }

    @FXML
    void Pane1_Seach_B_Click(MouseEvent event) {
        userEmail = Pane1_Email.getText().trim();

        if (userEmail.isEmpty()) {
            Pan1_Out.setText("Please enter your email");
            Pane1_Email.requestFocus();
            return;
        }

        if (!DBHelper.emailExists(userEmail)) {
            Pan1_Out.setText("Email not found!");
            Pane1_Email.requestFocus();
            return;
        }

        verificationCode = generateCode();
        Pane1_code_lable.setVisible(true);
        Pan1_Code_out.setText("Code: " + verificationCode);
        Pan1_Out.setText("");
        Pane1_Next_B.setVisible(true);
        Pane1_Seach_B.setDisable(true);
    }

    @FXML
    void Pane1_Back_B_Click(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/demo1/Login-Page.fxml")
            );
            Parent root = loader.load();

            Stage stage = (Stage) Pane3_Password.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Pane1_Next_B_Click(MouseEvent event) {
        Pane_1.setVisible(false);
        Pane_2.setVisible(true);
        Pan1_Out.setText("");
        Pan1_Code_out.setText("");
    }


    @FXML
    void Pane2_Back_B_Click(MouseEvent event) {
        Pane_2.setVisible(false);
        Pane_1.setVisible(true);
        Pane1_Email.clear();
        Pane2_Code.clear();
        Pane1_Seach_B.setDisable(false);
        Pane1_Next_B.setVisible(false);
    }

    @FXML
    void Pane2_Next_B_Click(MouseEvent event) {
        String enteredCode = Pane2_Code.getText().trim();

        if (!enteredCode.equals(verificationCode)) {
            Pan2_Out.setText("Invalid verification code");
            Pane2_Code.requestFocus();
            return;
        }

        Pane_2.setVisible(false);
        Pane_3.setVisible(true);
    }

    @FXML
    void Pane3_Back_B_Click(MouseEvent event) {
        Pane_3.setVisible(false);
        Pane_2.setVisible(true);
        Pane2_Code.clear();
    }

    @FXML
    void Pane3_Next_B_Click(MouseEvent event) {

        String pass1 = Pane3_Password.getText();
        String pass2 = Pane3_Com_Password.getText();

        if (pass1.isEmpty() || pass2.isEmpty()) {
            Pan3_Out.setText("Please enter password");
            return;
        }

        if (!pass1.equals(pass2)) {
            Pan3_Out.setText("Passwords don't match");
            return;
        }

        boolean updated = DBHelper.updatePassword(userEmail, pass1);

        if (updated) {
            Pan3_Out.setText("Password updated successfully!");

            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(e -> gotoLoginPage());
            pause.play();

        } else {
            Pan3_Out.setText("Error updating password");
        }
    }


    private void gotoLoginPage() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/demo1/Login-Page.fxml")
            );
            Parent root = loader.load();

            Stage stage = (Stage) Pane3_Password.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    void initialize() {
        Pane_2.setVisible(false);
        Pane_3.setVisible(false);
        Pane1_Next_B.setVisible(false);
        Pane1_code_lable.setVisible(false);

        Password_Visible.managedProperty().bind(PasswordCheckBox.selectedProperty());
        Password_Visible.visibleProperty().bind(PasswordCheckBox.selectedProperty());
        Pane3_Password.managedProperty().bind(PasswordCheckBox.selectedProperty().not());
        Pane3_Password.visibleProperty().bind(PasswordCheckBox.selectedProperty().not());
        Password_Visible.textProperty().bindBidirectional(Pane3_Password.textProperty());

        Com_Password_Visible.managedProperty().bind(Com_PassworddCheckBox.selectedProperty());
        Com_Password_Visible.visibleProperty().bind(Com_PassworddCheckBox.selectedProperty());
        Pane3_Com_Password.managedProperty().bind(Com_PassworddCheckBox.selectedProperty().not());
        Pane3_Com_Password.visibleProperty().bind(Com_PassworddCheckBox.selectedProperty().not());
        Com_Password_Visible.textProperty().bindBidirectional(Pane3_Com_Password.textProperty());
    }

}
