package arkanoidgame;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import attributes.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * class of animation runner the runs every animation that given for this method.
 */
public class AnimationRunner {
    private int framesPerSecond;
    private GUI gui;

    /**
     * constuctor of AnimationRunner.
     * @param gui the given gui.
     */
    public AnimationRunner(GUI gui) {
        this.framesPerSecond = 60;
        this.gui = gui;
    }

    /**
     * gui getter.
     * @return gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * the run loop of animation.
     * @param animation the given animation to run.
     */
    @SuppressWarnings("checkstyle:JavadocMethod")
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            DrawSurface d = this.gui.getDrawSurface();
            long startTime = System.currentTimeMillis(); // timing
            biuoop.Sleeper sleeper = new biuoop.Sleeper();

            animation.doOneFrame(d);
            this.gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}