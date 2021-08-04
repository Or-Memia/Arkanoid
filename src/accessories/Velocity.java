package accessories;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */


import shapes.Point;

/**
 * accessories.Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;


    // constructor

    /**
     * constructor that create a velocity.
     *
     * @param dx represents the x value of the velocity.
     * @param dy represents the y value of the velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * setting the x value of the velocity.
     *
     * @param dX represents the x value of the velocity.
     */
    public void setDx(double dX) {
        this.dx = dX;
    }

    /**
     * setting the y value of the velocity.
     *
     * @param dY represents the y value of the velocity.
     */
    public void setDy(double dY) {
        this.dy = dY;
    }

    /**
     * the method explained velocity by angle and speed.
     *
     * @param angle represents the angel of the route.
     * @param speed represents the value of the speed.
     * @return the change of x and y.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // 0 90 180 270
        double dx;
        double dy;
        double modAngle = angle % 360;
        if (modAngle == 0) {
            dx = 0;
            dy = -speed;
            return new Velocity(dx, dy);
        }
        if (modAngle == 90) {
            dx = speed;
            dy = 0;
            return new Velocity(dx, dy);
        }
        if (modAngle == 180) {
            dx = 0;
            dy = speed;
            return new Velocity(dx, dy);
        }
        if (modAngle == 270) {
            dx = -speed;
            dy = 0;
            return new Velocity(dx, dy);
        }

        dx = speed * Math.sin(Math.toRadians(modAngle));
        dy = -speed * Math.cos(Math.toRadians(modAngle));
        return new Velocity(dx, dy);
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p represents a point to measure from her the distance and determent the next point.
     * @return the next point at the route.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * the method returns the distance of x value to the next point.
     * <p>
     *
     * @return the distance of x value.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * the method returns the distance of y value to the next point.
     * <p>
     *
     * @return the distance of y value.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * the method returns the speed's values of the object.
     * <p>
     *
     * @return speed's values of the object.
     */
    public double getSpeed() {
        return Math.sqrt((dx * dx) + (dy * dy));
    }

}