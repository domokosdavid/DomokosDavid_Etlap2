package com.example.etllap.controllers;

import com.example.etllap.Controller;
import com.example.etllap.Etel;
import com.example.etllap.EtlapDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class HelloController extends Controller {
    @FXML
    private TableView<Etel> etelTable;
    @FXML
    private TableColumn<Etel, String> colNev;
    @FXML
    private TableColumn<Etel, Integer> colAr;
    @FXML
    private TableColumn<Etel, String> colKategoria;
    private EtlapDb db;

    public void initialize(){
        colNev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        colAr.setCellValueFactory(new PropertyValueFactory<>("ar"));
        colKategoria.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        try {
            db = new EtlapDb();
            etlapListaFeltolt();
        } catch (SQLException e) {
            hibaKiir(e);
        }
    }

    public TableColumn<Etel, String> getColNev() {
        return colNev;
    }

    public void felvetelButton(ActionEvent actionEvent) {
        try {
            Controller hozzadas = ujAblak("hozzaad-view.fxml", "Étel hozzáadása",
                    500, 400);
            hozzadas.getStage().setOnCloseRequest(event -> etlapListaFeltolt());
            hozzadas.getStage().show();
        } catch (Exception e) {
            hibaKiir(e);
        }
    }

    public void torlesButton(ActionEvent actionEvent) {
    }

    private void etlapListaFeltolt(){
        try {
            List<Etel> etelList = db.getEtelek();
            etelTable.getItems().clear();
            for(Etel etel: etelList){
                etelTable.getItems().add(etel);
            }
        } catch (SQLException e) {
            hibaKiir(e);
        }
    }
}