package levels;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import accessories.Velocity;
import attributes.Sprite;
import shapes.Block;

import java.util.List;

/**
 * the level information of levels in the game.
 */
public interface LevelInformation {

    /**
     * return the number of balls in the game.
     * @return the number of the balls in the game.
     */
    int numberOfBalls();

    /**
     * return the initial balls velocity and angle.
     * @return initial balls velocity and angle.
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the speed of the paddle.
     * @return the speed of the paddle.
     */
    int paddleSpeed();

    /**
     * return the width of the paddle.
     * @return the width of the paddle.
     */
    int paddleWidth();

    /**
     * return the name of the level.
     * @return the name of the level.
     */
    String levelName();

    /**
     * a background of a specific level.
     * @return the specific background.
     */
    Sprite getBackground();

    /**
     * a list of blocks that participate in a game.
     * @return the list of the blocks.
     */
    List<Block> blocks();

    /**
     * return the number of blocks at the list.
     * @return the number of blocks at the list.
     */
    int numberOfBlocksToRemove();
}