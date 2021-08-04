package observes;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

/**
 * This method is called whenever the beingHit object is hit.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * @param hl an hit listener object.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl an hit listener object.
     */
    void removeHitListener(HitListener hl);
}