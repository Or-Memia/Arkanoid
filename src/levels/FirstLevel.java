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
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the first level of the game.
 */
public class FirstLevel implements LevelInformation {

    /**
     * return the number of balls in the game.
     * @return the number of the balls in the game.
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * return the initial balls velocity and angle.
     * @return initial balls velocity and angle.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocities = new ArrayList<>();
        int speed = 5;
        for (int i = 0; i < numberOfBalls(); i++) {
            double angle = 0;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
            ballsVelocities.add(v);
        }
        return ballsVelocities;
    }

    /**
     * return the speed of the paddle.
     * @return the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return 7;
    }

    /**
     * return the width of the paddle.
     * @return the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return 100;
    }

    /**
     * return the name of the level.
     * @return the name of the level.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * a background of a specific level.
     * @return the specific background.
     */
    @Override
    public Sprite getBackground() {
        return new Level1BG();
    }

    /**
     * a list of blocks that participate in a game.
     * @return the list of the blocks.
     */
    @Override
    public List<Block> blocks() {
        int numberOfBlocks = 1;
        List<Block> blockLevel = new ArrayList<>();
        for (int i = 0; i < numberOfBlocks; i++) {
            Rectangle rect = new Rectangle(new Point(385, 180), 30, 30);
            Block bl = new Block(rect, Color.red);
            blockLevel.add(bl);
        }
        return blockLevel;
    }

    /**
     * return the number of blocks at the list.
     * @return the number of blocks at the list.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
