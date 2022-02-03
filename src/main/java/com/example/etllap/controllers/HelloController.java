package com.example.etllap.controllers;

import com.example.etllap.Controller;
import com.example.etllap.Etel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HelloController extends Controller {
    @FXML
    private TableView<Etel> etelTable;
    @FXML
    private TableColumn<Etel, String> colNev;
    @FXML
    private TableColumn<Etel, Integer> colAr;
    @FXML
    private TableColumn<Etel, String> colKategoria;


    public void felvetelButton(ActionEvent actionEvent) {
    }

    public void torlesButton(ActionEvent actionEvent) {
    }
}