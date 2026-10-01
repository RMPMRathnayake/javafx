package com.example.demo1.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo1.Database.DBHelper;
import com.example.demo1.Session.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PayPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem Card_B;

    @FXML
    private Button Card_Cancel_B;

    @FXML
    private Button Card_Next_B;

    @FXML
    private Label Card_Option_Out;

    @FXML
    private Pane Card_pane;

    @FXML
    private Pane Cart_D_B;

    @FXML
    private Button Cart_Pay_B;

    @FXML
    private MenuItem Cash_B;

    @FXML
    private Label Cash_Option_Out;

    @FXML
    private SplitMenuButton Home_Menu;

    @FXML
    private Label Card_out_put;

    @FXML
    private TextField Pay_Address;

    @FXML
    private TextField Pay_Card_CCV;

    @FXML
    private TextField Pay_Card_Month;

    @FXML
    private TextField Pay_Card_Name;

    @FXML
    private TextField Pay_Card_No;

    @FXML
    private TextField Pay_Card_Year;

    @FXML
    private TextField Pay_City;

    @FXML
    private TextField Pay_Name;

    @FXML
    private Label Pay_Out;

    @FXML
    private TextField Pay_Telephone;

    @FXML
    private MenuItem Menu_About_B;

    @FXML
    private MenuItem Menu_Cart_B;

    @FXML
    private MenuItem Menu_Logout_B;

    @FXML
    private MenuItem Menu_Home_B;

    @FXML
    private ImageView Home_B;

    @FXML
    private Pane PayDone_pane;

    @FXML
    private Button PayDone_B;

    @FXML
    private Label PaymentDone_Address;

    @FXML
    private Label PaymentDone_City;

    @FXML
    private Label PaymentDone_Name;

    @FXML
    private Label PaymentDone_PayOption1;

    @FXML
    private Label PaymentDone_PayOption2;

    @FXML
    private Label PaymentDone_Amount;

    @FXML
    private Label PaymentDone_TP;

    @FXML
    void Card_B_click(ActionEvent event) {
        Card_Option_Out.setVisible(true);
        Card_Option_Out.setText("Card Payment");
        Card_pane.setVisible(true);
        Cart_Pay_B.setDisable(true);
        Cash_Option_Out.setVisible(false);
        Card_pane.setDisable(false);
    }

    @FXML
    void Card_Cancel_B_Click(MouseEvent event) {
        Card_pane.setDisable(true);
        Cart_Pay_B.setDisable(false);
        Card_Option_Out.setVisible(true);
        Cash_Option_Out.setText("Cash Payment");
    }

    @FXML
    void Card_Next_B_Click(MouseEvent event) {
        String CardNo = Pay_Card_No.getText();
        String CardYear = Pay_Card_Year.getText();
        String CardMonth = Pay_Card_Month.getText();
        String CardName = Pay_Card_Name.getText();
        String CCV = Pay_Card_CCV.getText();

        if (CCV.isEmpty() || CardYear.isEmpty() || CardMonth.isEmpty() || CardName.isEmpty() || CardNo.isEmpty()) {
            Card_out_put.setText("Fill all the fields!");
            return;
        }

        if (CardNo.length() != 10) {
            Card_out_put.setText("Invalid Card No!");
            return;
        }

        if (CardYear.length() != 4) {
            Card_out_put.setText("Invalid Card Year!");
            return;
        }

        if (CardMonth.length() != 2) {
            Card_out_put.setText("Invalid Card Month!");
            return;
        }

        if (CCV.length() != 3) {
            Card_out_put.setText("Invalid Card CCV!");
            return;
        }
        Card_pane.setDisable(true);
        Cart_Pay_B.setVisible(true);
        Cart_Pay_B.setDisable(false);
    }

    @FXML
    void Cart_Pay_B_Click(MouseEvent event) {

        String name = Pay_Name.getText().trim();
        String address = Pay_Address.getText().trim();
        String tp = Pay_Telephone.getText().trim();
        String city = Pay_City.getText().trim();

        if (name.isEmpty() || address.isEmpty() || tp.isEmpty() || city.isEmpty()) {
            Pay_Out.setText("Fill all the fields!");
            return;
        }

        if (tp.length()<10 || (tp.contains("0") ||  tp.contains("+94"))) {
            Pay_Out.setText("Invalid Mobile Number!");
        }

        String paymentMethod = "";
        if (Card_Option_Out.isVisible() && Card_Option_Out.getText().equals("Card Payment")) {
            paymentMethod = "Card";
        } else if (Cash_Option_Out.isVisible() && Cash_Option_Out.getText().equals("Cash Payment")) {
            paymentMethod = "Cash";
        } else {
            Pay_Out.setText("Select a payment method!");
            return;
        }

        String amount = PaymentDone_Amount.getText().trim();
        if (amount.isEmpty()) {
            Pay_Out.setText("Amount not set!");
            return;
        }

        String username = UserSession.getUsername();
        if (username == null) {
            Pay_Out.setText("Please login again");
            return;
        }

        boolean saved = DBHelper.saveOrder(
                username,
                name,
                tp,
                address,
                city,
                paymentMethod,
                amount
        );

        if (saved) {
            Pay_Out.setText("Payment Successful!");
            PaymentDone_Name.setText(name);
            PaymentDone_Address.setText(address);
            PaymentDone_TP.setText(tp);
            PaymentDone_City.setText(city);
            PaymentDone_Amount.setText(amount);
            PaymentDone_PayOption1.setText(paymentMethod);

            PayDone_pane.setVisible(true);
            Cart_D_B.setVisible(false);
        } else {
            Pay_Out.setText("Payment Failed!");
        }
    }



    @FXML
    void Cash_B_click(ActionEvent event) {
        Card_pane.setVisible(false);
        Card_Option_Out.setVisible(false);
        Cash_Option_Out.setVisible(true);
        Cash_Option_Out.setText("Cash Payment");
        Cart_Pay_B.setDisable(false);
        Card_pane.setDisable(false);
    }

    @FXML
    void Menu_About_B_click(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/demo1/About-Page.fxml")
            );
            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup()
                    .getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Menu_History_B_click(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/demo1/OrderView-Page.fxml")
            );
            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup()
                    .getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void PayDone_B_Click(MouseEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home-Page.fxml"));
            Scene scene = Home_B.getScene();
            scene.setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Menu_Cart_B_click(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/demo1/Home-Page.fxml")
            );

            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup()
                    .getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Menu_Logout_B_click(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/demo1/Login-Page.fxml")
            );
            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup()
                    .getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Home_B_Click(MouseEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home-Page.fxml"));
            Scene scene = Home_B.getScene();
            scene.setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAmount(String amount) {
        PaymentDone_Amount.setText(amount);
    }

    @FXML
    void initialize() {
        Card_pane.setVisible(false);
        PayDone_pane.setVisible(false);

    }



}
