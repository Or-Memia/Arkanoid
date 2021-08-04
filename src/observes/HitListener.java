package observes;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import shapes.Ball;
import shapes.Block;

/**
 * This method is called whenever the beingHit object is hit.
 */
public interface HitListener {
    /**
     * events the happening in game that after it the ball should be removed.
     * @param beingHit the hitted block by a ball object.
     * @param hitter The hitter parameter is the shapes.Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}