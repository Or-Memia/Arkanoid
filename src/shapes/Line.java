package shapes; /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-05-06
 */

import java.util.InputMismatchException;

/**
 * this class represents a line in 2 dimension.
 */
public class Line {
    private Point start, end;

    // constructors

    /**
     * constructor that create a new line with 2 points.
     *
     * @param start represent the start point of the line
     * @param end   represent the end point of the line
     */
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    /**
     * constructor that create a new line with 4 values of 2 points (2 values for each).
     *
     * @param x1 represnt the x value of the start point
     * @param y1 represnt the y value of the start point
     * @param x2 represnt the x value of the end point
     * @param y2 represnt the y value of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * the method checks the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * the method checks the middle point of a segment.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        //average for x
        double avgX = (start.getX() + end.getX()) / 2;
        //average for y
        double avgY = (start.getY() + end.getY()) / 2;
        Point p = new Point(avgX, avgY);
        return p;
    }


    /**
     * check the start point of the line.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * the method checks if two lines shares same intersection point.
     *
     * @param other represent other line that has a check if it has an intersection point with the given line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (this.intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * the method checks the intersection point with other line and bring it back.
     *
     * @param other represent other line that has a check if it has an intersection point with the given line.
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //??? ?????? ??????? ???? ?y
        if (this.isParallelToY() && other.isParallelToY()) {
            if (other.start.distance(other.end) != 0) {

                if (!isStraightRallying(other)) {
                    return null;
                }
            }
            if (this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY()
                    || (this.start.getX() == other.end.getX() && this.start.getY() == other.end.getY())) {
                if (this.inRange(this.start) && other.inRange(this.start)) {
                    return this.start;
                }
            }
            if (this.inRange(getPointRange(other)) && other.inRange(getPointRange(other))) {
                return getPointRange(other);
            }
            //throw new InputMismatchException("something was wrong");
        }

        //?? ???? ??? ????? ???? ?y
        if (this.isParallelToY()) {
            double intersectX = this.start.getX();
            double intersectY = this.start.getX() * other.getSlope() + other.getB();
            if (intersectY >= Math.max(this.start.getY(), this.end.getY())
                    || intersectY <= Math.min(this.start.getY(), this.end.getY())) {
                return null;
            }
            Point p = new Point(intersectX, intersectY);
            if (!this.inRange(p)) {
                return null;
            }
            if (this.inRange(p) && other.inRange(p)) {
                return p;
            }
            //           throw new InputMismatchException("something was wrong");
        }

        //?? ???? ???? ????? ???? ?y
        if (other.isParallelToY()) {
            double intersectX = other.start.getX();
            double intersectY = other.start.getX() * this.getSlope() + this.getB();
            if (intersectY > Math.max(other.start.getY(), other.end.getY())
                    || intersectY < Math.min(other.start.getY(), other.end.getY())) {
                return null;
            }
            Point p = new Point(intersectX, intersectY);
            if (!other.inRange(p)) {
                return null;
            }
            if (this.inRange(p) && other.inRange(p)) {
                return p;
            }
            //    throw new InputMismatchException("something was wrong");
        }

        //?? ???????? ?? ??? ?????? ?????
        if (this.getSlope() == other.getSlope()) {
            if (!isStraightRallying(other)) {
                return null;
            }
            if ((this.start.getX() == other.start.getX() && this.start.getY() == this.start.getY()
                    || (this.start.getX() == other.end.getX() && this.start.getY() == other.end.getY()))) {
                if (this.inRange(this.start) && other.inRange(this.start)) {
                    return this.start;
                }
            }
            if (this.inRange(getPointRange(other)) && other.inRange(getPointRange(other))) {
                return getPointRange(other);
            }
            throw new InputMismatchException("something was wrong");
        }

        //?? ???????? ?? ?????
        double mL1 = this.getSlope();
        double mL2 = other.getSlope();
        double bL1 = this.getB();
        double bL2 = other.getB();
        double intersectX = (bL1 - bL2) / (mL2 - mL1);
        double intersectY = intersectX * mL1 + bL1;
        Point p = new Point(intersectX, intersectY);
        if (!other.inRange(p)) {
            return null;
        }
        if (this.inRange(p) && other.inRange(p)) {
            return p;
        }
        return null;


    }

    /**
     * check if the intersection point with given line is a start or end point of those lines.
     * <p>
     *
     * @param other is a line that have an intersection point with this line.
     * @return the common point between those lines.
     */
    private Point getPointRange(Line other) {
        if ((this.end.getX() == other.start.getX() && this.end.getY() == other.start.getY())
                || (this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY())) {
            return this.end;
        }
        return null;
    }

    /**
     * checks if two lines are equals.
     * <p>
     *
     * @param other represent a line that check if it has the same length with the given line.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.distance(this.end) == other.start.distance(other.end));
    }

    /**
     * the method checks the slope of the given line.
     *
     * @return the slope of the given line.
     */
    public double getSlope() {
        double deltaXL1 = this.start.getX() - this.end.getX();
        double deltaYL1 = this.start.getY() - this.end.getY();
        return deltaYL1 / deltaXL1;
    }

    /**
     * the method checks the y value of the intersection with y axes of the given line.
     *
     * @return the y value of the intersection with y axes of the given line.
     */
    public double getB() {
        return start.getY() - this.getSlope() * start.getX();
    }

    /**
     * the method checks if the line is parallel to y axe or not.
     *
     * @return true if the line is parallel to y or false otherwise.
     */
    public boolean isParallelToY() {
        return this.start.getX() == this.end.getX();
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.

    /**
     * this method determent which point from all points at list that have an intersection with specific rectangle,
     * have the closest distance (assuming there are more than one point), in case of one point the method
     * returns this point.
     *
     * @param rect a given rectangle that have an intersection points with trajectory line.
     * @return the point that has the closest distance to a start of given line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.intersectionPoints(this).size() == 1) {
            return rect.intersectionPoints(this).get(0);
        }

        if (rect.intersectionPoints(this).size() == 2) {
            double minDistance1 = rect.intersectionPoints(this).get(0).distance(start);
            double minDistance2 = rect.intersectionPoints(this).get(1).distance(start);
            if (minDistance1 > minDistance2) {
                return rect.intersectionPoints(this).get(1);
            } else {
                return rect.intersectionPoints(this).get(0);
            }
        }
        return null;
    }

    /**
     * the method check if two lines have more than one intersection point.
     *
     * @param other is an other line the have an intersection points with this line.
     * @return true if the lines have only one intersection point, false otherwise.
     */
    public boolean isStraightRallying(Line other) {
        double d1 = this.start.distance(other.end);
        double d2 = this.start.distance(other.start);
        double d3 = this.end.distance(other.start);
        double d4 = this.end.distance(other.end);
        return 0 == d1 || 0 == d2 || 0 == d3 || 0 == d4;
    }

    /**
     * check if the intersection points found in range of two segments.
     *
     * @param p represent an intersection point.
     * @return true if the point is in the range of the segment, false otherwise.
     */
    public boolean inRange(Point p) {
        double x = p.getX();
        double y = p.getY();
        double eps = 0.00001;
        return (x <= Math.max(this.start.getX(), this.end.getX()) + eps
                && x >= Math.min(this.start.getX(), this.end.getX()) - eps)
                && (y <= Math.max(this.start.getY(), this.end.getY()) + eps
                && y >= Math.min(this.start.getY(), this.end.getY()) - eps);
    }
}