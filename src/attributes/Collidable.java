package attributes;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import accessories.Velocity;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;

/**
 * this interface represent collidable object and how its behave while collision.
 */
public interface Collidable {

    /**
     * the method returns the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * <p>
     *
     * @param collisionPoint  represents the collision point by two objects
     * @param currentVelocity represents the current velocity of the object that collide the rectangles.
     * @param hitter the hitter ball in the game.
     * @return is the new velocity expected after the hit.
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter);
}