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
import javafx.scene.control.RadioButton;
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

    @FXML
    RadioButton q1;

    @FXML
    RadioButton q2;

    @FXML
    RadioButton q3;

    QuestionGenerator questionGenerator = new QuestionGenerator(App.levelHard);
    String[][] oneQuestion = questionGenerator.buildQuestion();

    public void placeQuestion() {
        miLabel.setText(oneQuestion[0][0]);
        q1.setText(oneQuestion[1][0]);
        q2.setText(oneQuestion[1][1]);
        q3.setText(oneQuestion[1][2]);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.questionControl = "other";
        placeQuestion();
    }

    public void handleKeyPressed(KeyEvent event) throws IOException {
        switch (event.getCode().toString()) {
            case "E":
                App.questionControl = "play";
                App.setRoot("gameCore");
                break;
        }
    }

    public void verification(String answer) throws IOException {
        if (oneQuestion[2][0].equals(answer)) {
            App.questionControl = "play";
            App.setRoot("gameCore");
        } else {
            App.setRoot("gameOver");
        }
    }

    public void handleQone() throws IOException {
        this.verification(oneQuestion[1][0]);
    }

    public void handleQtwo() throws IOException {
        this.verification(oneQuestion[1][1]);
    }

    public void handleQthree() throws IOException {
        this.verification(oneQuestion[1][2]);
    }

}
