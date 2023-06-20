/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import com.mycompany.learninvaders.GameCoreController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jarg
 */
public class Avion {

    private int x, y, vidas;
    String nameImage;
    int speedMove = 6;

    public Avion(int x, int y, int vidas, String nameImage) {
        this.x = x;
        this.y = y;
        this.vidas = vidas;
        this.nameImage = nameImage;
        this.setX(x);
        this.setY(y);
//        image = new Image("@naveNaranja.png");
//        this.setFill(new ImagePattern(image));
        municiones = new Municion[200];
    }

    public void placeAvion(GraphicsContext graphic) {
        graphic.drawImage(GameCoreController.images.get(nameImage), x, y);
    }

    public int getSpeedMove() {
        return speedMove;
    }

    public void setSpeedMove(int speedMove) {
        this.speedMove = speedMove;
    }

    public void move() {
        if (GameCoreController.goLeft) {
            if (x <= 0) {
                x = 0;
            } else {
                x -= speedMove;
            }
        }
        if (GameCoreController.goRight) {
            if (x >= 924) {
                x = 924;
            } else {
                x += speedMove;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Municion[] getMuniciones() {
        return municiones;
    }

    public void setMuniciones(Municion[] municiones) {
        this.municiones = municiones;
    }

    Image image;
    Municion[] municiones;

    public void mover(int direccion) {
        this.setY(this.getY() + direccion);
    }

}
