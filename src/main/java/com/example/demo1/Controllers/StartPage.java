package com.example.demo1.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class StartPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
        PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
        delay.setOnFinished(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/Login-Page.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) Window.getWindows().stream()
                        .filter(Window::isShowing)
                        .findFirst()
                        .orElse(null);

                if (stage != null) {
                    stage.setScene(new Scene(root));
                    stage.show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        delay.play();
    }

}
