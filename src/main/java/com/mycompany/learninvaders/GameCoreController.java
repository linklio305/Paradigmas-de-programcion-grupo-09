/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.learninvaders;

import contenido.Avion;
import java.io.IOException;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jarg
 *
 * la logica principal es utilizar la libreria animation timer para poder
 * renderizar varias veces imagenes en un segundo y lograr el efecto de un
 * videojuego.
 */
public class GameCoreController {

    Avion avion;
    private GraphicsContext graficos;
    private int x = 0;
    public static boolean goRight;
    public static boolean goLeft;

//    los hashMap son extramadamente importantes para la optimizacion del uso del disco.
//    Usar siempre hashMaps para el renderizado de cualquier imagen esto permite usar la imagen 
//    desde la ram.
    public static HashMap<String, Image> images;

    @FXML
    private Canvas miCanva;

    //Si bien no se usa esate recurso, debido al uso de fxml se conserva por el momento.
    @FXML
    private AnchorPane miPane;

    public void initialize() {
        createPlayer();
        cicloJuego();
    }

    public void createPlayer() {
        images = new HashMap<String, Image>();
        loadImages();
        graficos = miCanva.getGraphicsContext2D();
        miCanva.setFocusTraversable(true);
        avion = new Avion(462, 666, 3, "nave");
    }

    public void loadImages() {
        images.put("nave", new Image("/imagenes/naves/naveBlanca.png"));
    }

    public void draw() {
        graficos.clearRect(0, 0, miCanva.getWidth(), miCanva.getHeight());
        avion.placeAvion(graficos);
    }

    // ciclo de juego principal
    public void cicloJuego() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long currentTime) {
                upState();
                draw();
            }
        };
        animationTimer.start();
    }

    public void upState() {
        avion.move();
    }

    //Funcion para devolverse, se debe configurar el menu al precionar scape.
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void handleKeyPressed(KeyEvent event) {
        switch (event.getCode().toString()) {
            case "D":
                goRight = true;
                break;
            case "A":
                goLeft = true;
                break;
            case "W":
                avion.setSpeedMove(12);
        }
    }

//codigo encargado de enviar instrucciones a la nave pintada
    public void handleKeyReleased(KeyEvent event) {
        switch (event.getCode().toString()) {
            case "D":
                goRight = false;
                break;
            case "A":
                goLeft = false;
                break;
            case "W":
                avion.setSpeedMove(6);
        }
    }

}
