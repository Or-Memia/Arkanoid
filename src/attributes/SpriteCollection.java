package attributes; /**
 /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * a list of sprites.
 */
public class SpriteCollection {

    private List<Sprite> sprites;

    /**
     * a list of sprites.
     */
    public SpriteCollection() {
        sprites = new ArrayList<Sprite>();
    }

    /**
     * adding sprite to a list of sprites.
     *
     * @param s sprite object
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * removing sprites objects from list of sprites.
     * @param s @param s the sprite object that removed from list.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }


    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sp = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : sp) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d is a draw surface that draw all sprites on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.sprites) {
            sprite.drawOn(d);
        }
    }
}