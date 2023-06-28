/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import com.mycompany.learninvaders.GameCoreController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jarg
 */
public class Player extends GameObject {

    private int vidas;

    public Player(int vidas, int x, int y, int speedMove, String nameImage) {
        super(x, y, speedMove, nameImage);
        this.vidas = vidas;
    }

    @Override
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

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, 100, 100);
    }

    public boolean checkTouch(EBullet ebullet) {
        if (this.getRectangle().getBoundsInLocal().intersects(ebullet.getRectangle().getBoundsInLocal())) {
            return true;
        }
        return false;
    }

    @Override
    public void drawSome(GraphicsContext graphic) {
        graphic.drawImage(GameCoreController.images.get(this.nameImage), this.x, this.y);
    }
}
