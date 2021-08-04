package observes;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import accessories.Counter;
import arkanoidgame.GameLevel;
import shapes.Ball;
import shapes.Block;

/**
 * this class removes ball from game while "special events" happened.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor of ball remover.
     * @param game the actual game the we play.
     * @param removedBalls counter of how many balls is left.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    // Balls that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    /**
     * events the happening in game that after it the ball should be removed.
     * @param beingHit the hitted block by a ball object.
     * @param hitter The hitter parameter is the shapes.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //hitter.removeHitListener(this);
        hitter.removeFromGame(this.game);
        //hitter.getGameEnvironment().removeCollidable(beingHit);
        this.remainingBalls.decrease(1);
    }
}

