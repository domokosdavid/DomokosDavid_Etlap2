module com.example.etllap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.etllap to javafx.fxml;
    exports com.example.etllap;
}