package shapes; /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-05-06
 */

import accessories.Velocity;
import arkanoidgame.GameLevel;
import attributes.Collidable;
import attributes.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class represent the paddle of an arkanoid game.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor ks;
    private Block block;
    private int limitLeft;
    private int limitRight;
    private int speed;
    private int paddleWidth;

    /**
     * constructor of the paddle.
     * @param block  block of the paddle.
     * @param ks the given keyboard sensor.
     * @param limitLeft limitLeft  the limit of the left.
     * @param limitRight  limitRight the limit of right.
     * @param speed the speed of the ball after collision wuth the paddle.
     * @param paddleWidth the width of the paddle.
     */
    @SuppressWarnings("checkstyle:JavadocMethod")
    public Paddle(Block block, KeyboardSensor ks, int limitLeft, int limitRight, int speed, int paddleWidth) {
        this.block = block;
        this.ks = ks;
        this.limitLeft = limitLeft;
        this.limitRight = limitRight;
        this.speed = speed;
        this.paddleWidth = paddleWidth;
    }

    /**
     * moving the paddle left.
     */
    public void moveLeft() {
        Rectangle rect = this.block.getCollisionRectangle();
        if (rect.getUpperLeft().getX() > limitLeft) {
            rect.changeUpperLeftX(-speed);
        }

    }

    /**
     * moving the paddle right.
     */
    public void moveRight() {
        Rectangle rect = this.block.getCollisionRectangle();
        if (rect.getUpperRight().getX() < limitRight) {
            rect.changeUpperLeftX(speed);
        }
    }

    /**
     * using this method when the time is passed.
     */
    public void timePassed() {
        if (ks.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
        if (ks.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
    }

    /**
     * @param d object
     */
    public void drawOn(DrawSurface d) {
        block.drawOn(d);
    }

    /**
     * attributes.Collidable.
     *
     * @return the rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    /**
     *
     * @param collisionPoint  represents the collision point by two objects
     * @param currentVelocity represents the current velocity of the object that collide the rectangles.
     * @param hitter represents the ball that hitter the paddle.
     * @return the current velocity.
     */
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter) {
        int var = paddleWidth / 10;
        if (this.block.getCollisionRectangle().getUpperLeft().getX() < collisionPoint.getX() && collisionPoint.getX()
                < this.block.getCollisionRectangle().getUpperLeft().getX() + var) {
            currentVelocity = Velocity.fromAngleAndSpeed(-78, 5);
        }
        if (this.block.getCollisionRectangle().getUpperLeft().getX() + var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 2 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(-66, 5);
            ;
        }
        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 2 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 3 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(-44, 5);
            ;
        }
        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 3 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 4 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(-22, 5);

        }
        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 4 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 5 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(-5, 5);
        }

        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 5 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 6 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(5, 5);
        }

        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 6 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 7 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(22, 5);
        }

        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 7 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 8 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(44, 5);
        }

        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 8 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 9 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(66, 5);
        }

        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 9 * var < collisionPoint.getX()
                && collisionPoint.getX() < this.block.getCollisionRectangle().getUpperLeft().getX() + 10 * var) {
            currentVelocity = Velocity.fromAngleAndSpeed(78, 5);
        }
        // From Left
        if (this.block.getCollisionRectangle().getUpperLeft().getX() == collisionPoint.getX()) {
            currentVelocity.setDx(-currentVelocity.getDx());
        }
        // From right.
        if (this.block.getCollisionRectangle().getUpperRight().getX() == collisionPoint.getX()) {
            currentVelocity.setDx(-currentVelocity.getDx());
        }
        return currentVelocity;
    }

    /**
     * @param collisionPoint  the collision point
     * @param currentVelocity the velocity
     * @return the new hit
     */

    /**
     * Add this paddle to the game.
     * @param g adding the paddle
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}