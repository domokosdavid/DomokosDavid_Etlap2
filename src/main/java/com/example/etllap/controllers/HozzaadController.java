package com.example.etllap.controllers;

import com.example.etllap.Controller;
import com.example.etllap.EtlapDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HozzaadController extends Controller {

    @FXML
    private TextField inputNev;
    @FXML
    private TextArea inputLeiras;
    @FXML
    private ChoiceBox inputKategoria;
    @FXML
    private Spinner<Integer> inputAr;

    private EtlapDb db;

    @FXML
    public void hozzaadButtonClick(ActionEvent actionEvent) {
        String nev = inputNev.getText().toString();
        String leiras = inputLeiras.getText().toString();
        Object kategoria = inputKategoria.getValue().toString();
        int ar = inputAr.getValue();
        try {
            db = new EtlapDb();
            int siker = db.etelHozzaadasa(nev, leiras, ar, (String) kategoria);
            if (siker == 1){
                alert("Film hozzáadása sikeres");
            } else {
                alert("Film hozzáadása sikeretelen");
            }
        } catch (Exception e) {
            hibaKiir(e);
        }
}

}
