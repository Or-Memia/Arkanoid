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
 * the second level's background.
 */
public class Level2BG implements Sprite {

    /**
     * draw on screen all sprites.
     * @param d represent a window to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(150, 190, 220));
        d.fillRectangle(0, 20, 800, 600);
        d.setColor(new Color(255, 220, 100));
        for (int i = 0; i < 800; i += 7) {
            d.drawLine(100, 100, i, 250);
        }
        d.setColor(new Color(255, 220, 100));
        d.fillCircle(100, 100, 45);
        d.setColor(new Color(255, 200, 0));
        d.fillCircle(100, 100, 36);
        d.setColor(new Color(255, 170, 0));
        d.fillCircle(100, 100, 27);


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
