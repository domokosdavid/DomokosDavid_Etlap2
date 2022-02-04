package com.example.etllap.controllers;

import com.example.etllap.Controller;
import com.example.etllap.EtlapDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class HozzaadController extends Controller {

    @FXML
    private TextField inputNev;
    @FXML
    private TextArea inputLeiras;
    @FXML
    private ChoiceBox<String> inputKategoria;
    @FXML
    private Spinner<Integer> inputAr;

    private EtlapDb db;

    public void initialize() throws SQLException{
        inputKategoria.getSelectionModel().selectFirst();
        db = new EtlapDb();
    }

    @FXML
    public void hozzaadButtonClick(ActionEvent actionEvent){
        String nev = inputNev.getText().toString();
        String leiras = inputLeiras.getText().toString();
        String kategoria = inputKategoria.getSelectionModel().getSelectedItem();

        int ar = inputAr.getValue();
        try {
            int siker = db.etelHozzaadasa(nev, leiras, ar, kategoria);
            if (siker == 1){
                alert("Étel hozzáadása sikeres");
            } else {
                alert("Étel hozzáadása sikeretelen");
            }
        } catch (Exception e) {
            hibaKiir(e);
        }
}

}
