package arkanoidgame; /**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import accessories.Counter;
import attributes.Animation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * a class of arkanoidgame.GameFlow- manage the animations in the game.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private GUI gui;
    private Counter score;

    /**
     * constructor of game flow.
     * @param ar the given animation runner.
     * @param ks the given keyboard sensor.
     * @param gui the given gui.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.ar = ar;
        this.ks = ks;
        this.gui = gui;
        this.score = new Counter();
    }

    /**
     * a run method that runs the animations in the list.
     * @param levels the given list of levels to run.
     */
    @SuppressWarnings("checkstyle:JavadocMethod")
    public void runLevels(List<levels.LevelInformation> levels) {
        for (levels.LevelInformation levelInfo : levels) {
            Animation a = new GameLevel(gui, ks, ar, levelInfo, score);
            ar.run(a);

            GameLevel level = new GameLevel(gui, this.ks, this.ar, levelInfo, score);

            level.initialize();

            while (level.getCounterBalls().getValue() != 0 || level.getCounterBlocks().getValue() != 0) {
                level.run();

                if (level.getCounterBalls().getValue() == 0) {
                    GameOver go = new GameOver(score);
                    KeyPressStoppableAnimation kpsla = new KeyPressStoppableAnimation(ks, "space", go);
                    this.ar.run(kpsla);
                    this.ar.getGui().close();
                    break;
                }
                if (level.getCounterBlocks().getValue() == 0) {
                    score.increase(100);
                    break;
                }
            }
        }
        Win win = new Win(score);
        KeyPressStoppableAnimation kpsa = new KeyPressStoppableAnimation(ks, "space", win);
        this.ar.run(kpsa);
        score.decrease(100);

        this.ar.getGui().close();
    }

}