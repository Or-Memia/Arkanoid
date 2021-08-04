package attributes;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import biuoop.DrawSurface;

/**
 * an interface of animation the runs in the game.
 */
public interface Animation {

    /**
     * the next step of animation.
     * @param d the given drawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * when the animation should stop.
     * @return true if should stop, false otherwise.
     */
    boolean shouldStop();
}