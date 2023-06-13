/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jarg
 */
public class Avion extends Rectangle {

    int x, y;
    Image image;
    Municion[] municiones;

    public Avion(int x, int y) {
        this.x = x;
        this.y = y;
        this.setX(x);
        this.setY(y);
        this.setWidth(300);
        this.setHeight(300);
//        image = new Image("./naveNaranja.png");
        this.setFill(new ImagePattern(image));
        municiones = new Municion[200];
    }

    public void mover(int direccion) {
        this.setY(this.getY() + direccion);
    }

}
