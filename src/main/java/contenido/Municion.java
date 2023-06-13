/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author jarg
 */
public class Municion extends Circle{
    int x,y; Image ima;
    public Municion(int x, int y, int tipo){
        this.x = x;
        this.y = y;
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.setRadius(15);
        this.setFill(Color.GREEN);
    }
}
