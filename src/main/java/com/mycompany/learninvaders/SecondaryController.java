package com.mycompany.learninvaders;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SecondaryController implements Initializable {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToGameCore() throws IOException {
        App.setRoot("gameCore");
    }

    @FXML
    private void easyMode() throws IOException {
        App.levelHard = "easy";
        switchToGameCore();
    }

    @FXML
    private void mediumMode() throws IOException {
        App.levelHard = "medium";
        switchToGameCore();
    }

    @FXML
    private void hardMode() throws IOException {
        App.levelHard = "hard";
        switchToGameCore();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
