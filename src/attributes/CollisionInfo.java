package attributes; /**
 /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import shapes.Point;

/**
 * this class represents the collision information of a collidable object.
 */
public class CollisionInfo {

    private Point point;
    private Collidable collidable;

    /**
     * constructor that create collision information object with collision point and collidable object.
     *
     * @param point      is a point that notify the collision point of of an object.
     * @param collidable is the collidable object.
     */
    public CollisionInfo(Point point, Collidable collidable) {
        this.point = point;
        this.collidable = collidable;
    }

    /**
     * the method returns the point at which the collision occurs.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.point;

    }

    /**
     * the method returns the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;

    }
}