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
 * the third level's background.
 */
public class Level3BG implements Sprite {

    /**
     * draw on screen all sprites.
     * @param d represent a window to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        int dx = 20;
        int xp = 60;
        int yp = 410;
        d.setColor(new Color(60, 110, 50));
        d.fillRectangle(0, 20, 800, 600);
        d.setColor(Color.black);
        d.fillRectangle(50, 400, 114, 200);
        d.setColor(Color.black);
        d.setColor(Color.white);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                d.fillRectangle(xp + j * dx, yp, 12, 30);
            }
            yp += 37;
        }
        d.setColor(new Color(70, 70, 70));
        d.fillRectangle(95, 350, 24, 50);
        d.setColor(new Color(78, 78, 78));
        d.fillRectangle(103, 200, 8, 150);
        d.setColor(Color.orange);
        d.fillCircle(107, 182, 18);
        d.setColor(Color.red);
        d.fillCircle(107, 182, 12);
        d.setColor(Color.white);
        d.fillCircle(107, 182, 6);
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
