package com.example.demo1.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class AboutPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Home_B;

    @FXML
    private ImageView Close_B;

    @FXML
    void Close_B_Click(MouseEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home-Page.fxml"));
            Scene scene = Close_B.getScene();
            scene.setRoot(newRoot);
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

    @FXML
    void initialize() {
        assert Close_B != null : "fx:id=\"About_back\" was not injected: check your FXML file 'About-Page.fxml'.";
        assert Home_B != null : "fx:id=\"Home_B\" was not injected: check your FXML file 'About-Page.fxml'.";

    }

}
