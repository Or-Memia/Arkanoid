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
import java.util.Random;

/**
 * the fourth level of the game.
 */
public class FourthLevel implements LevelInformation {

    /**
     * return the number of balls in the game.
     * @return the number of the balls in the game.
     */
    @Override
    public int numberOfBalls() {
        return 3;
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
            Random random = new Random();
            double angle = random.nextInt(140) - 70;
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
        return "Final Four";
    }

    /**
     * a background of a specific level.
     * @return the specific background.
     */
    @Override
    public Sprite getBackground() {
        return new Level4BG();
    }

    /**
     * a list of blocks that participate in a game.
     * @return the list of the blocks.
     */
    @Override
    public List<Block> blocks() {
        int numberOfLines = 7;
        int numberOfBlocks = 15;
        double dx = -50;
        double xp = 728;
        double yp = 150;
        List<Block> blockLevel = new ArrayList<>();
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfBlocks; j++) {
                Point p = new Point(xp, yp);

                Rectangle rect = new Rectangle(new Point(p.getX() + j * dx, p.getY()), 50, 17);
                Block bl = new Block(rect, Color.lightGray);
                if (i == 1) {
                    bl.setColor(Color.red);
                }
                if (i == 2) {
                    bl.setColor(Color.yellow);
                }
                if (i == 3) {
                    bl.setColor(Color.green);
                }
                if (i == 4) {
                    bl.setColor(Color.white);
                }
                if (i == 5) {
                    bl.setColor(Color.pink);
                }
                if (i == 6) {
                    bl.setColor(Color.cyan);
                }
                blockLevel.add(bl);
            }
            yp += 17;
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
