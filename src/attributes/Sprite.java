package attributes; /**
 /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import arkanoidgame.GameLevel;
import biuoop.DrawSurface;

/**
 * this interface represent a sprite object.
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d represent a window to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * adding a sprite to the game.
     * @param g the given game.
     */
    void addToGame(GameLevel g);
}