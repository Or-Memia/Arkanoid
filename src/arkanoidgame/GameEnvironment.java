package arkanoidgame; /**
 /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import attributes.Collidable;
import attributes.CollisionInfo;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

import java.util.ArrayList;
import java.util.List;


/**
 * this class represent a list of collidables objects in an environment.
 */
public class GameEnvironment {
    private List<Collidable> collidables;


    /**
     * constructor that create a new list of collidables objects.
     */
    public GameEnvironment() {
        collidables = new ArrayList<Collidable>();
    }


    /**
     * add the given collidable to the environment.
     *
     * @param c is a collidable object in the list.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * removing collidables objects from list of collidable.
     * @param c the collision object that removed from list.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * this method updating the attributes.CollisionInfo about the closest point of
     * hitting, if this object will not collide with
     * any of the collidables in this collection, the method returns null. Else, the method return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory is the line that for him we check if there are intersection points.
     * @return if there wasn't intersection point, the method returns null, otherwise the method returns the closest
     * collision that is going to occur
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //initialised the variables
        Point closestPoint = null;
        Collidable lastColObject = null;
        // running on the list of rectangles
        for (Collidable c : collidables) {
            Rectangle rect = c.getCollisionRectangle();
            //if there was one intersection point or more between trajectory and one of the rectangles
            if (!rect.intersectionPoints(trajectory).isEmpty()) {
                Point closestPCol = trajectory.closestIntersectionToStartOfLine(rect);
                //checks if there is areal intersecting between the rectangle and the segment
                if (closestPoint == null) {
                    closestPoint = closestPCol;
                    lastColObject = c;
                }
                //comparing between two distances of the closest intersection points between two rectangles
                // and determent which is closer
                double distance1 = trajectory.start().distance(closestPCol);
                double distance2 = trajectory.start().distance(closestPoint);
                if (distance1 < distance2) {
                    closestPoint = closestPCol;
                    lastColObject = c;
                }

            }
        }
        //if there is a closest point after running the list
        if (closestPoint != null) {
            CollisionInfo colInf = new CollisionInfo(closestPoint, lastColObject);
            return colInf;
        }
        return null;
    }

}
