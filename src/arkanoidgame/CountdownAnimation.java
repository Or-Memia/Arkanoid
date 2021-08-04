package arkanoidgame;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import attributes.Animation;
import attributes.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

// The arkanoidgame.CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.

/**
 * class of CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private boolean stop;
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;

    /**
     * constructor of CountdownAnimation.
     * @param numOfSeconds number of seconds between frames.
     * @param countFrom count from a number to zero.
     * @param gameScreen the given game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.stop = false;
        this.numOfSeconds = numOfSeconds * 1000;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;

    }

    /**
     * the next step of CountdownAnimation.
     * @param d the given drawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        d.setColor(Color.blue);
        d.fillRectangle(0, 20, 800, 600);
        this.gameScreen.drawAllOn(d);

        if (countFrom == 3) {
            d.setColor(Color.magenta);
            d.drawText(390, 80, Integer.toString(countFrom), 32);
        }
        if (countFrom == 2) {
            sleeper.sleepFor(600);
            d.setColor(Color.magenta);
            d.drawText(390, 80, Integer.toString(countFrom), 32);
        }
        if (countFrom == 1) {
            sleeper.sleepFor(600);
            d.setColor(Color.magenta);
            d.drawText(390, 80, Integer.toString(countFrom), 32);
        }
        if (this.countFrom == 0) {
            sleeper.sleepFor(600);
            d.setColor(Color.magenta);
            d.drawText(390, 80, "GO!", 32);
        }
        if (this.countFrom < 0) {
            sleeper.sleepFor(200);
            this.stop = true;
        }
        countFrom--;

    }

    /**
     * when CountdownAnimation should stop.
     * @return true if should stop, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}