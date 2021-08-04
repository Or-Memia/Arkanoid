package levels;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import arkanoidgame.GameLevel;
import attributes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the first level's background.
 */
public class Level1BG implements Sprite {

    /**
     * draw on screen all sprites.
     * @param d represent a window to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 20, 800, 600);
        d.setColor(Color.blue);
        d.fillCircle(400, 195, 155);
        d.setColor(Color.black);
        d.fillCircle(400, 195, 150);
        d.setColor(Color.blue);
        d.fillCircle(400, 195, 110);
        d.setColor(Color.black);
        d.fillCircle(400, 195, 105);
        d.setColor(Color.blue);
        d.fillCircle(400, 195, 60);
        d.setColor(Color.black);
        d.fillCircle(400, 195, 55);
        d.setColor(Color.blue);
        d.fillRectangle(397, 30, 6, 145);
        d.fillRectangle(397, 215, 6, 145);
        d.fillRectangle(220, 192, 145, 6);
        d.fillRectangle(435, 192, 145, 6);

    }

    /**
     * empty method.
     */
    @Override
    public void timePassed() {

    }

    /**
     * add the background to the game.
     * @param g the given game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
