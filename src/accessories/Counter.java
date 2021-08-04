package accessories;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

/**
 * a counter to count objects that created in game.
 */
public class Counter {
    private int counter = 0;

    /**
     * add number to current count.
     * @param number increasing number of count.
     */
    public void increase(int number) {
        counter += number;
    }

    /**
     * subtract number from current count.
     * @param number decreasing number of count.
     */
    public void decrease(int number) {
        counter -= number;
    }

    /**
     *  get current count.
     * @return the value's counter.
     */
    public int getValue() {
        return counter;
    }
}