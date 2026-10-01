package com.example.demo1.Controllers;

import com.example.demo1.Database.DBHelper;
import com.example.demo1.Models.Order;
import com.example.demo1.Session.UserSession;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderViewPage {
    @FXML
    private ImageView Home_B;

    @FXML
    private SplitMenuButton Home_Menu;

    @FXML
    private MenuItem Menu_About_B;

    @FXML
    private MenuItem Menu_Cart_B;

    @FXML
    private MenuItem Menu_History_B;

    @FXML
    private MenuItem Menu_Logout_B;

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private TableColumn<Order, String> colAmount;

    @FXML
    private TableColumn<Order, String> colPayment;

    @FXML
    private TableColumn<Order, String> colDate;

    @FXML
    private TableColumn<Order, String> colItems;

    private void loadOrders() {
        String username = UserSession.getUsername(); // get current user
        if (username == null) return;

        ObservableList<Order> orders = DBHelper.getOrdersByUser(username);
        orderTable.getItems().clear();
        orderTable.setItems(orders);
    }

    @FXML
    void Home_B_Click(MouseEvent event) throws IOException {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home-Page.fxml"));
            Scene scene = Home_B.getScene();
            scene.setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Menu_About_B_click(ActionEvent event) throws IOException {
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
    void Menu_Cart_B_click(ActionEvent event) throws IOException {
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
    void Menu_History_B_click(ActionEvent event) throws IOException {
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
    void Menu_Logout_B_click(ActionEvent event) throws IOException {
        UserSession.clear();
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

    private void switchScene(ActionEvent event, String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) ((MenuItem) event.getSource())
                .getParentPopup()
                .getOwnerWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void switchScene(String fxml, ImageView source) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        source.getScene().setRoot(root);
    }

    @FXML
    void initialize() {
        colAmount.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getAmount()));
        colPayment.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPayment()));
        colDate.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDate()));

        loadOrders();
    }
}
