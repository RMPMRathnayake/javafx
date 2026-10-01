module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires jdk.compiler;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.Controllers;
    opens com.example.demo1.Controllers to javafx.fxml;
}