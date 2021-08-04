/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import arkanoidgame.GameFlow;
import levels.FirstLevel;
import levels.SecondLevel;
import levels.ThirdLevel;
import levels.FourthLevel;
import levels.LevelInformation;
import arkanoidgame.AnimationRunner;
import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/***
 * the main of the project.
 */
public class Ass6Game {

    /**
     * the main of the project.
     *
     * @param args not using the args.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("ass6", 800, 600);
        AnimationRunner ar = new AnimationRunner(gui);
        biuoop.KeyboardSensor ks = ar.getGui().getKeyboardSensor();
        GameFlow gF = new GameFlow(ar, ks, gui);
        List<LevelInformation> gameLevel = new ArrayList<>();
        FirstLevel level1 = new FirstLevel();
        SecondLevel level2 = new SecondLevel();
        ThirdLevel level3 = new ThirdLevel();
        FourthLevel level4 = new FourthLevel();

        for (String arg : args) {
            if (arg.equals("1")) {
                gameLevel.add(level1);
            }
            if (arg.equals("2")) {
                gameLevel.add(level2);
            }
            if (arg.equals("3")) {
                gameLevel.add(level3);
            }
            if (arg.equals("4")) {
                gameLevel.add(level4);
            }
        }

        if (gameLevel.size() == 0) {
            gameLevel.add(level1);
            gameLevel.add(level2);
            gameLevel.add(level3);
            gameLevel.add(level4);
        }
        gF.runLevels(gameLevel);
    }
}
