package com.example.etllap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void felvetelButton(ActionEvent actionEvent) {
    }

    public void torlesButton(ActionEvent actionEvent) {
    }
}