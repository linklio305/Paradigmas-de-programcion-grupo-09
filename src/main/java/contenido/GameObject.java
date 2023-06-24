/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jarg
 */
public abstract class GameObject {

    protected int x, y;
    protected int speedMove;
    protected String nameImage;

    public abstract void drawSome(GraphicsContext graphic);

    public abstract void move();

    public GameObject(int x, int y, int speedMove, String nameImage) {
        this.x = x;
        this.y = y;
        this.speedMove = speedMove;
        this.nameImage = nameImage;
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

    public int getSpeedMove() {
        return speedMove;
    }

    public void setSpeedMove(int speedMove) {
        this.speedMove = speedMove;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

}
