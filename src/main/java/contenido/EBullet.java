/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import com.mycompany.learninvaders.GameCoreController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jarg
 */
public class EBullet extends GameObject {

    public EBullet(int x, int y, int speedMove, String nameImage) {
        super(x, y, speedMove, nameImage);
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

    @Override
    public void drawSome(GraphicsContext graphic) {
         graphic.drawImage(GameCoreController.images.get(this.nameImage), this.x, this.y);
    }

    @Override
    public void move() {
        y += speedMove;
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, 70, 100);
    }

    public boolean checkTouch(Player player) {
        if (this.getRectangle().getBoundsInLocal().intersects(player.getRectangle().getBoundsInLocal())) {
            return (true);
        }
        return false;
    }

}
