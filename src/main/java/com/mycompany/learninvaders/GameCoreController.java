/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.learninvaders;

import contenido.BackGroundAnimated;
import contenido.Bullet;
import contenido.EBullet;
import contenido.Player;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

    GraphicsContext graficos;
    int speedEBullet;
    int x = 0;
    int probability;

    public static boolean goRight;
    public static boolean goLeft;

    List<Player> listEnemies = new ArrayList<>();
    List<Bullet> listBullets = new ArrayList<>();
    List<EBullet> listEBullets = new ArrayList<>();

//    los hashMap son extramadamente importantes para la optimizacion del uso del disco.
//    Usar siempre hashMaps para el renderizado de cualquier imagen esto permite usar la imagen 
//    desde la ram.
    public static HashMap<String, Image> images;

    @FXML
    Canvas miCanva;

    //Si bien no se usa esate recurso, debido al uso de fxml se conserva por el momento.
    @FXML
    AnchorPane miPane;

    public void initialize() {
        initComponents();
        App.questionControl = "play";
        System.out.println(listEBullets.size());
        System.out.println(avion.getX());
        cicloJuego();
    }

    public void initComponents() {
        images = new HashMap<String, Image>();
        loadImages();
        graficos = miCanva.getGraphicsContext2D();
        miCanva.setFocusTraversable(true);
        switch (App.levelHard) {
            case "easy":
                avion = new Player(3, 462, 666, 12, "nave_easy");
                speedEBullet = 20;
                probability = 100;
                break;
            case "medium":
                avion = new Player(3, 462, 666, 12, "nave_medium");
                speedEBullet = 30;
                probability = 80;
                break;
            case "hard":
                avion = new Player(3, 462, 666, 12, "nave_hard");
                speedEBullet = 40;
                probability = 50;
                break;
        }
        backgroundAnimated = new BackGroundAnimated(0, 0, 3, "dynamic", "dynamicRev");
        createEnemies();
    }

    public void loadImages() {
        images.put("nave_easy", new Image("/imagenes/naves/naveNaranja.png"));
        images.put("nave_medium", new Image("/imagenes/naves/naveBlanca.png"));
        images.put("nave_hard", new Image("/imagenes/naves/naveNegra.png"));
        images.put("background", new Image("/imagenes/fondoSolo.png"));
        images.put("dynamic", new Image("/imagenes/dinamicos/fondo_dinamico.png"));
        images.put("dynamicRev", new Image("/imagenes/dinamicos/fondo_dinamico_2.png"));
        images.put("enemy", new Image("/imagenes/naves/eBasico.png"));
        images.put("bullet", new Image("/imagenes/bala.png"));
        images.put("ebullet", new Image("/imagenes/eBullet.png"));
    }

    // ciclo de juego principal
    public void cicloJuego() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long currentTime) {

                if (App.questionControl == "question") {
                    try {
                        moveToQuestion();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (App.questionControl == "play") {
                    draw();
                    upState();
                }
            }
        };
        animationTimer.start();
    }

    //funcion para actualizar los dibujos graficados en pantalla
    public void upState() {
        avion.move();
        backgroundAnimated.move();
        moveBullets();
        collisionHandle();
        collisionEHandle();
        shotRandomEBullet();
    }

    public void draw() {
        graficos.clearRect(0, 0, miCanva.getWidth(), miCanva.getHeight());
        backgroundAnimated.drawSome(graficos);
        drawEnemies();
        drawEBullets();
        moveEBullets();
        avion.drawSome(graficos);
        drawBullets();
    }

    //funcion para crear enemigos
    public void createEnemies() {
        for (int i = 1; i < 6; i++) {
            listEnemies.add(new Player(1, 150 * i, 100, 0, "enemy"));
        }
    }

    //Funcion para actulizar el estado de los enemigos
    public void drawEnemies() {
        Iterator<Player> enemies = listEnemies.iterator();
        while (enemies.hasNext()) {
            enemies.next().drawSome(graficos);
        }
    }

    //funcion para disparar balas del jugador
    public void shotBullet() {
        listBullets.add(new Bullet(avion.getX() + 50, avion.getY() - 100, 20, "bullet"));
        shotRandomEBullet();
    }

    public void drawBullets() {
        Iterator<Bullet> bullets = listBullets.iterator();
        while (bullets.hasNext()) {
            bullets.next().drawSome(graficos);
        }
    }

    public void moveBullets() {
        Iterator<Bullet> bulletIterator = listBullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            bullet.move();
            if (bullet.getY() < 0) {
                bulletIterator.remove();
            }
        }
    }

    public void shotEBullet(Player enemy) {
        listEBullets.add(new EBullet(enemy.getX() + 15, enemy.getY() + 100, speedEBullet, "ebullet"));
    }

    public void shotRandomEBullet() {
        Iterator<Player> enemies = listEnemies.iterator();
        SecureRandom secureRandom = new SecureRandom();
        while (enemies.hasNext()) {
//            System.out.println(probability);
            int randomNumber = secureRandom.nextInt(probability) + 1;
            Player enemy = enemies.next();
            if (randomNumber == 1) {
                shotEBullet(enemy);
                break;
            }
        }
    }

    public void drawEBullets() {
        Iterator<EBullet> ebullets = listEBullets.iterator();
        while (ebullets.hasNext()) {
            EBullet oneEB = ebullets.next();
            oneEB.drawSome(graficos);
        }
    }

    public void moveEBullets() {
        Iterator<EBullet> ebullets = listEBullets.iterator();
        while (ebullets.hasNext()) {
            EBullet ebullet = ebullets.next();
            ebullet.move();
            if (ebullet.getY() > 1024) {
                ebullets.remove();
            }
        }
    }

    public void collisionHandle() {
        Iterator<Bullet> bulletIterator = listBullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            Iterator<Player> enemies = listEnemies.iterator();
            while (enemies.hasNext()) {
                Player enemy = enemies.next();
                if (bullet.checkTouch(enemy)) {
                    bulletIterator.remove();
                    enemies.remove();
                }
            }
        }
    }

    public void collisionEHandle() {
        Iterator<EBullet> ebullets = listEBullets.iterator();
//        System.out.println(listEBullets.size());
        while (ebullets.hasNext()) {
            EBullet ebullet = ebullets.next();
            if (avion.checkTouch(ebullet)) {
                System.out.println("aqui");
                goRight = false;
                goLeft = false;
                ebullets.remove();
                App.questionControl = "question";
                break;
            }
        }
    }

    public void moveToQuestion() throws IOException {
        App.setRoot("question");
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
                avion.setSpeedMove(24);
                break;
            case "SPACE":
                shotBullet();
                break;
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
                avion.setSpeedMove(12);
                break;
            case "Q":
                App.setRoot("question");
                break;
        }
    }

}
