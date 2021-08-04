package observes;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

// a observes.BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.


import accessories.Counter;
import arkanoidgame.GameLevel;
import shapes.Ball;
import shapes.Block;

/**
 * a observes.BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class  BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    private Counter score;

    /**
     * constructor of block remover.
     * @param game the actual game the we play.
     * @param removedBlocks counter of how many block is left.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;

    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.

    /**
     * events the happening in game that after it the ball should be removed.
     * @param beingHit the hitted block by a ball object.
     * @param hitter The hitter parameter is the shapes.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        hitter.getGameEnvironment().removeCollidable(beingHit);
        remainingBlocks.decrease(1);
    }
}