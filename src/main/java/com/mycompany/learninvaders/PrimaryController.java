package com.mycompany.learninvaders;

import contenido.Memory;
import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
//        construccion de memoria en progreso
//        Memory.setNameUser(nameUser);
        App.setRoot("secondary");
    }
}
