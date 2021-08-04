package shapes;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-04-22
 */


import accessories.Velocity;
import arkanoidgame.GameLevel;
import arkanoidgame.GameEnvironment;
import attributes.Collidable;
import attributes.CollisionInfo;
import attributes.Sprite;
import biuoop.DrawSurface;
import observes.HitListener;
import observes.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a ball in 2 dimension.
 */
public class Ball implements Sprite, HitNotifier {
    private int r;
    private Point center;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners = new ArrayList<>();


    // constructors

    /**
     * constructor that create a ball.
     *
     * @param center represent the center point of the ball.
     * @param r      represent the radius of the ball.
     * @param color  represent the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.r = r;
        this.center = center;
        this.color = color;
        this.gameEnvironment = null;
    }

    /**
     * constructor that create a ball.
     *
     * @param x     represent the x value of the center point.
     * @param y     represent the y value of the center point.
     * @param r     represent the radius of the ball.
     * @param color represent the color of the ball.
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.gameEnvironment = null;
    }

    // accessors

    /**
     * the method returns the x value of the given center point of the ball.
     *
     * @return the y value of the center point.
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * the method returns the y value of the given center point of the ball.
     *
     * @return the y value of the center point.
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * the method returns the size of the radius of the ball.
     *
     * @return the radius's value of the ball.
     */
    public int getSize() {
        return r;
    }

    /**
     * the method returns the color of the ball.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return color;
    }

    // draw the ball on the given DrawSurface

    /**
     * the method draw the ball on the given DrawSurface.
     *
     * @param surface represent a window to draw on the ball.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }


    /**
     * the method sets velocity to the ball.
     *
     * @param v represents the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * the method sets velocity by parameters that represent
     * the length of distance between the next point.
     *
     * @param dx represent the x distance of the next point moving.
     * @param dy represent the y distance of the next point moving.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * the method returns the velocity of the ball.
     *
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }


    /**
     * the method determent how the next step of the ball will be.
     */
    public void timePassed() {
        double nextPointX = this.center.getX() + this.velocity.getDx();
        double nextPointY = this.center.getY() + this.velocity.getDy();
        Line trajectory = new Line(this.center.getX(), this.center.getY(), nextPointX, nextPointY);
        CollisionInfo closestCollision = gameEnvironment.getClosestCollision(trajectory);
        if (closestCollision == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            Point collisionPoint = closestCollision.collisionPoint();
            Collidable collidable = closestCollision.collisionObject();
            this.velocity = collidable.hit(collisionPoint, velocity, this);
        }
    }

    /**
     * the method returns the list of blocks the found in game environment.
     *
     * @return the list of blocks the found in game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * the method sets the list of blocks the found in game environment.
     *
     * @param gE is the list of collision blocks at game environment.
     */
    public void setGameEnvironment(GameEnvironment gE) {
        this.gameEnvironment = gE;
    }

    /**
     * adding sprite's objects to the game.
     *
     * @param g the given game environment list.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * removing sprite's objects to the game.
     * @param game the game that played.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);

    }

    /**
     * adding hitListener's objects to the game.
     * @param hl an hit listener object.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * removing hitListener's objects to the game.
     * @param hl an hit listener object.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
