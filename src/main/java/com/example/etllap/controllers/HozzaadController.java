package com.example.etllap.controllers;

import com.example.etllap.Controller;
import com.example.etllap.Etel;
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
        if (nev.isEmpty()){
            alert("A név mező nem lehet üres!");
            return;
        }
        String leiras = inputLeiras.getText().toString();
        if (leiras.isEmpty()){
            alert("A leírás mező nem lehet üres!");
            return;
        }
        String kategoria = inputKategoria.getSelectionModel().getSelectedItem();
        if (kategoria == null){
            alert("Nem lehet üres a kategória választó!");
            return;
        }

        int ar = inputAr.getValue();
        if (ar <= 0){
            alert("Az ár nem lehet kisebb 0-nál, de 0 sem lehet!");
            return;
        }
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
