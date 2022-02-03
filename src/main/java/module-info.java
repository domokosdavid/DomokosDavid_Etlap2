module com.example.etllap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.etllap to javafx.fxml;
    exports com.example.etllap;
    exports com.example.etllap.controllers;
    opens com.example.etllap.controllers to javafx.fxml;
}