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
 * the fourth level's background.
 */
public class Level4BG implements Sprite {

    /**
     * draw on screen all sprites.
     * @param d represent a window to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        int dx = 10;
        int xp = 60;
        int yp = 410;
        d.setColor(new Color(0, 180, 255));
        d.fillRectangle(0, 20, 800, 600);
        d.setColor(new Color(70, 70, 70));
        d.setColor(Color.lightGray);
        for (int i = 0; i < 10; i++) {
            d.drawLine(110 + dx * i, 435, 95 + dx * i, 600);
            d.drawLine(620 + dx * i, 520, 600 + dx * i, 600);
        }

        d.fillCircle(100, 415, 20);
        d.fillCircle(120, 450, 27);
        d.fillCircle(610, 500, 20);
        d.fillCircle(630, 535, 27);
        d.setColor(new Color(170, 170, 170));
        d.fillCircle(140, 425, 30);
        d.fillCircle(650, 510, 30);
        d.setColor(new Color(160, 160, 160));
        d.fillCircle(160, 440, 20);
        d.fillCircle(180, 415, 30);
        d.fillCircle(670, 525, 20);
        d.fillCircle(690, 510, 30);
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
