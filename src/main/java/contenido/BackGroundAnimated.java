/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import com.mycompany.learninvaders.GameCoreController;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jarg
 */
public class BackGroundAnimated extends GameObject {

    private String secondImage;
    private int y2 = -3232;

    public BackGroundAnimated(int x, int y, int speedMove, String nameImage, String secondImage) {
        super(x, y, speedMove, nameImage);
        this.secondImage = secondImage;
    }

    @Override
    public void drawSome(GraphicsContext graphic) {
        graphic.drawImage(GameCoreController.images.get(this.nameImage), this.x, this.y - 1232);
        graphic.drawImage(GameCoreController.images.get(this.secondImage), this.x, this.y2);
    }

    @Override
    public void move() {
        y += speedMove;
        y2 += speedMove;
        if (y >= 2000) {
            this.y = -1994;
        }
        if (y2 >= 768) {
            this.y2 = -3228;
        }
    }

}
