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
import attributes.SpriteCollection;
import biuoop.DrawSurface;
import observes.HitListener;
import observes.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represent a block that created by rectangle and implements collidable and sprite interfaces.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners = new ArrayList<>();
    private Rectangle rect;
    private Color color;
    private SpriteCollection sprites;

    /**
     * the method represents the changing in blocks while the program runs.
     */
    public void timePassed() {
    }


    /**
     * constructor that create a block by rectangle and color.
     *
     * @param block represent the block of the rectangle.
     * @param color represent the color of the rectangle.
     */
    public Block(Rectangle block, Color color) {
        this.rect = block;
        this.color = color;
    }

    @Override
    /**
     * this method getting the collision rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rect;
    }


    @Override
    /**
     * getting the velocity after hit.
     */
    public Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter) {

        // From Left
        if (rect.getUpperLeft().getX() == collisionPoint.getX()) {
            currentVelocity.setDx(-currentVelocity.getDx());
            this.notifyHit(hitter);
        }
        // From right.
        if (rect.getUpperRight().getX() == collisionPoint.getX()) {
            currentVelocity.setDx(-currentVelocity.getDx());
            this.notifyHit(hitter);
        }
        // From up.
        if (rect.getUpperLeft().getY() == collisionPoint.getY()) {
            currentVelocity.setDy(-currentVelocity.getDy());
            this.notifyHit(hitter);
        }
        // From bottom.
        if (rect.getDownerRight().getY() == collisionPoint.getY()) {
            currentVelocity.setDy(-currentVelocity.getDy());
            this.notifyHit(hitter);
        }

        return currentVelocity;
    }

    /**
     * setting the color.
     * @param color1 is the color that set.
     */
    public void setColor(Color color1) {
        this.color = color1;
    }

    /**
     * the method returns the color of the object.
     *
     * @return the color of the object.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * the method draw the block on the given DrawSurface.
     *
     * @param surface represent a window to draw on the ball.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * adding block collidable to the game.
     *
     * @param g is the specific block that added to the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * removing sprite's objects to the game.
     * @param game the game that played.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
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

    /**
     * Make a copy of the hitListeners before iterating over them and notify all listeners about a hit event.
     * @param hitter the hitter ball in the game.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
