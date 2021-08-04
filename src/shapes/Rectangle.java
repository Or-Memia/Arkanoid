package shapes; /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-05-06
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;
//    private shapes.Line upperLine, downLine, leftLine, rightLine;
    // Create a new rectangle with location and width/height.

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft the upper left edge of a rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

    }

    /**
     * change the x value of the upper left edge of the rectangle.
     *
     * @param x the x
     */
    public void changeUpperLeftX(int x) {
        this.upperLeft = new Point(upperLeft.getX() + x, upperLeft.getY());
    }


    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * @param line line to intersection
     * @return list of point
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> interPoints = new ArrayList<>();
        // check the intersection points between the line to rectangle 4 edges:
        if (getUpperLine().isIntersecting(line)) {
            interPoints.add(getUpperLine().intersectionWith(line));
        }
        if (getDownerLine().isIntersecting(line)) {
            interPoints.add(getDownerLine().intersectionWith(line));
        }
        if (getLeftLine().isIntersecting(line)) {
            interPoints.add(getLeftLine().intersectionWith(line));
        }
        if (getRightLine().isIntersecting(line)) {
            interPoints.add(getRightLine().intersectionWith(line));
        }

        return interPoints;
    }

    /**
     * the method returns the color of the rectangle.
     *
     * @return the color of the rectangle.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * the method returns the upper line of the rectangle.
     *
     * @return the upper line of the rectangle.
     */
    public Line getUpperLine() {
        Line l = new Line(upperLeft, getUpperRight());
        return l;
    }

    /**
     * the method returns the downer line of the rectangle.
     *
     * @return the downer line of the rectangle.
     */
    public Line getDownerLine() {
        Line l = new Line(this.getDownerLeft(), getDownerRight());
        return l;
    }

    /**
     * the method returns the lefter line of the rectangle.
     *
     * @return the lefter line of the rectangle.
     */
    public Line getLeftLine() {
        Line l = new Line(new Point(upperLeft.getX(), upperLeft.getY()), getDownerLeft());
        return l;
    }

    /**
     * the method returns the righter line of the rectangle.
     *
     * @return the righter line of the rectangle.
     */
    public Line getRightLine() {
        Line l = new Line(new Point(getUpperRight().getX(), getUpperRight().getY()), getDownerRight());
        return l;
    }

    // Return the width and height of the rectangle

    /**
     * the method returns the width of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * the method returns the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    // Returns the upper-left point of the rectangle.

    /**
     * the method returns the upper left edge of the rectangle.
     *
     * @return the upper left edge of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * the method returns the upper right edge of the rectangle.
     *
     * @return the upper right edge of the rectangle.
     */
    public Point getUpperRight() {
        return new Point(upperLeft.getX() + width, upperLeft.getY());
    }

    /**
     * the method returns the downer left edge of the rectangle.
     *
     * @return the downer left edge of the rectangle.
     */
    public Point getDownerLeft() {
        return new Point(upperLeft.getX(), upperLeft.getY() + height);
    }

    /**
     * the method returns the downer right edge of the rectangle.
     *
     * @return the downer right edge of the rectangle.
     */
    public Point getDownerRight() {
        return new Point(upperLeft.getX() + width, upperLeft.getY() + height);
    }
}