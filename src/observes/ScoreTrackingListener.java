package observes; /**
 /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import accessories.Counter;
import shapes.Ball;
import shapes.Block;

/**
 *  this method update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor of observes.ScoreTrackingListener.
     * @param scoreCounter the counter that updating.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * events the happening in game that after it the ball should be removed.
     * @param beingHit the hitted block by a ball object.
     * @param hitter The hitter parameter is the shapes.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}