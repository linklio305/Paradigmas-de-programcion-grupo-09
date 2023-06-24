/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.learninvaders;

import contenido.BackGroundAnimated;
import contenido.Player;
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

    Player avion;
    BackGroundAnimated backgroundAnimated;
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
        initComponents();
        cicloJuego();
    }

    public void initComponents() {
        images = new HashMap<String, Image>();
        loadImages();
        graficos = miCanva.getGraphicsContext2D();
        miCanva.setFocusTraversable(true);
        avion = new Player(3, 462, 666, 6, "nave");
        backgroundAnimated = new BackGroundAnimated(0, 0, 6, "dynamic", "dynamicRev");
    }

    public void loadImages() {
        images.put("nave", new Image("/imagenes/naves/naveBlanca.png"));
        images.put("background", new Image("/imagenes/fondoSolo.png"));
        images.put("dynamic", new Image("/imagenes/dinamicos/fondo_dinamico.png"));
        images.put("dynamicRev", new Image("/imagenes/dinamicos/fondo_dinamico_2.png"));
        images.put("enemy", new Image("/imagenes/naves/eBasico.png"));
    }

    public void createEnemies() {
        for (int i = 1; i < 6; i++) {
            Player enemy = new Player(1, 150 * i, 200, 0, "enemy");
            enemy.drawSome(graficos);
        }
    }

    public void draw() {
        graficos.clearRect(0, 0, miCanva.getWidth(), miCanva.getHeight());
        backgroundAnimated.drawSome(graficos);
        avion.drawSome(graficos);
        createEnemies();
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
        backgroundAnimated.move();
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
    public void handleKeyReleased(KeyEvent event) throws IOException {
        switch (event.getCode().toString()) {
            case "D":
                goRight = false;
                break;
            case "A":
                goLeft = false;
                break;
            case "W":
                avion.setSpeedMove(6);
                break;
            case "Q":
                App.setRoot("question");
        }
    }

}
