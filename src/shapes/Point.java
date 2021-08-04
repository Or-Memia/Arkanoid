package shapes; /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-04-22
 */

/**
 * this class represents a point in 2 dimension.
 */
public class Point {
    private double x;
    private double y;


    /**
     * constructor that create a new point with values.
     *
     * @param x represent the x coordination in a 2 dimension point.
     * @param y represent the y coordination in a 2 dimension point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * the method measure the distance between to points.
     *
     * @param other represent the point that from her measure the distance to the local point.
     * @return return the distance of this point to the other point.
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /**
     * the method receive a point and check if they have the same coordination.
     *
     * @param other represent a point that has the same values with the other.
     * @return return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return (this.x == other.getX()) && (this.y == other.getY());
    }

    // Return the x and y values of this point

    /**
     * the method returns the x value of the given point.
     *
     * @return the x value of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * the method return the y value of the point.
     *
     * @return the y value of the point.
     */
    public double getY() {
        return this.y;
    }

}
