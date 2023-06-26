package com.mycompany.learninvaders;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField textField;

    @FXML
    private void switchToSecondary() throws IOException {
//        construccion de memoria en progreso  
        System.out.println(textField.getText());
        App.userName = textField.getText();
        App.setRoot("secondary");
    }
}
