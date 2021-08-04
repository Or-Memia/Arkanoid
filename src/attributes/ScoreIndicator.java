package attributes; /**
 /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import levels.LevelInformation;
import accessories.Counter;
import arkanoidgame.GameLevel;
import biuoop.DrawSurface;
import shapes.Rectangle;

import java.awt.Color;

/**
 * attributes.ScoreIndicator is in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private Rectangle rect;
    private LevelInformation levelInfo;

    /**
     * constructor of score indicator.
     * @param score score counter of the game.
     * @param rect the rectangle the holds the score's text.
     * @param levelInfo the level information of a specific level.
     */
    public ScoreIndicator(Counter score, Rectangle rect, LevelInformation levelInfo) {
        this.score = score;
        this.rect = rect;
        this.levelInfo = levelInfo;
    }

    /**
     * this method draw the rectangles that holds the score's text.
     * @param d represent a window to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        String s = Integer.toString(score.getValue());
        d.setColor(Color.black);
        double xSize = 350;
        double ySize = 14;
        d.drawText((int) xSize, (int) ySize, "score:" + s, 14);
        d.drawText(600, 14, "Level Name:  " + levelInfo.levelName(), 14);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add this paddle to the game.
     * @param g adding the paddle
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
