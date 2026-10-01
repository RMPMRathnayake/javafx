package com.example.demo1;

import com.example.demo1.Database.DBHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBHelper.createUsersTable();
        DBHelper.createOrdersTable();

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Start-Page.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Pizza ගින්න\uD83C\uDF55\n!");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
