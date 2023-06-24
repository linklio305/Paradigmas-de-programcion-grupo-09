/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.learninvaders;

import contenido.QuestionGenerator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jarg
 */
public class QuestionController implements Initializable {

    @FXML
    AnchorPane miPane;

    @FXML
    Label miLabel;

    QuestionGenerator questionGenerator;

    public void placeQuestion() {
        questionGenerator = new QuestionGenerator("easy");
        String[][] oneQuestion = questionGenerator.buildQuestion();
        miLabel.setText(oneQuestion[0][0]);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        placeQuestion();
    }

    public void handleKeyPressed(KeyEvent event) throws IOException {
        System.out.println("hace algo");
        switch (event.getCode().toString()) {
            case "E":
                App.setRoot("gameCore");
                break;
        }
    }

}
