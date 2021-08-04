package arkanoidgame;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import accessories.Counter;
import attributes.Animation;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a class of an end screen: "Game Over".
 */
public class GameOver implements Animation {
    private Counter score;
    private boolean stop;

    /**
     * constructor of GameOver.
     * @param score the accumulate score of the player after losing.
     */
    public GameOver(Counter score) {
        this.score = score;
        this.stop = false;

    }

    /**
     * the next step of GameOver.
     * @param d the given drawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        String s = Integer.toString(score.getValue());
        d.setColor(Color.black);
        d.drawText(160, d.getHeight() / 2, "Game Over. Your score is " + s, 32);
    }

    /**
     * when GameOver should stop.
     * @return true if should stop, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}