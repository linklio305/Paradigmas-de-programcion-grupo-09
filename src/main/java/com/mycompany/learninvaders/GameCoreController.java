/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.learninvaders;

import contenido.Avion;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jarg
 */
public class GameCoreController {

    Avion avion;

    @FXML
    private Pane miPane;

    public void initialize() {
        createPlayer();
    }

    public void add(Node e) {
        miPane.getChildren().add(e);
        miPane.requestFocus();
    }

    public void createPlayer() {
        avion = new Avion(200, 200);
        add(avion);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        KeyCode keycode = event.getCode();
        avion.mover(-10);
    }
}
