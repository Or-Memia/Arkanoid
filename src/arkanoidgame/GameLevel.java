package arkanoidgame;
/**
 * @author Or Memia ormem25@gmail.com
 * 205892664
 * @version 1.0
 * @since 2020-06-14
 */

import levels.LevelInformation;
import accessories.Counter;
import accessories.Velocity;
import attributes.Animation;
import attributes.ScoreIndicator;
import attributes.Sprite;
import attributes.SpriteCollection;
import attributes.Collidable;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import observes.BallRemover;
import observes.BlockRemover;
import observes.ScoreTrackingListener;
import shapes.Ball;
import shapes.Rectangle;
import shapes.Paddle;
import shapes.Point;
import shapes.Block;

import java.awt.Color;

/**
 * a game class that do initialize for the game, and run it.
 */
public class GameLevel implements Animation {
    private CountdownAnimation ca;
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private biuoop.KeyboardSensor ks;
    private Counter counterBalls;
    private Counter counterBlocks;
    private Counter score;
    private GUI gui;
    private LevelInformation levelInfo;
    private static final int GAME_HIGHT = 600;
    private static final int GAME_WIDTH = 800;

    /**
     * counting the blocks.
     * @return the number of blocks that has been count.
     */
    public Counter getCounterBlocks() {
        return counterBlocks;
    }

    /**
     * counting the balls.
     * @return the number of balls that has been count.
     */
    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     * gui getter.
     * @return gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * constructor of game.
     * @param gui the given gui.
     * @param ks the given keyboard sensor.
     * @param r1 the given animation runner.
     * @param levelInfo the given level i formation of a specific level.
     * @param score the given score of the player.
     */
    @SuppressWarnings("checkstyle:JavadocMethod")
    public GameLevel(GUI gui, KeyboardSensor ks, AnimationRunner r1, LevelInformation levelInfo, Counter score) {
        this.counterBalls = new Counter();
        this.counterBlocks = new Counter();
        this.score = score;
        this.running = true;
        this.sprites = new SpriteCollection();
        this.ks = ks;
        this.gui = gui;
        this.runner = r1;
        this.ca = ca;
        this.environment = new GameEnvironment();
        this.levelInfo = levelInfo;
    }

    /**
     * adding collidable object to list of collidables at game environment.
     *
     * @param c the collision object that added to list.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adding sprites objects to list of sprites.
     *
     * @param s the sprite object that added to list.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        SpriteCollection sprites1 = new SpriteCollection();
        this.sprites = sprites1;
        sprites1.addSprite(levelInfo.getBackground());

        Rectangle rectangleScore = new Rectangle(new Point(0, 0), 800, 20);
        Rectangle rectangle = new Rectangle(new Point(0, 20), 800, 20);
        Block block1 = new Block(rectangle, Color.BLUE);
        Rectangle rectangle2 = new Rectangle(new Point(0, 20), 20, 600);
        Block block2 = new Block(rectangle2, Color.BLUE);
        Rectangle rectangle3 = new Rectangle(new Point(780, 20), 20, 600);
        Block block3 = new Block(rectangle3, Color.BLUE);
        Rectangle rectangle4 = new Rectangle(new Point(0, 600), 800, 20);
        Block deathRegion = new Block(rectangle4, Color.BLUE);
        BallRemover removeBalls = new BallRemover(this, this.counterBalls);
        block1.addToGame(this);
        block2.addToGame(this);
        block3.addToGame(this);
        deathRegion.addToGame(this);

        Rectangle r = new Rectangle(new Point(350, 560), levelInfo.paddleWidth(), 13);
        Paddle paddle = new Paddle(new Block(r, Color.yellow), ks, 20, 780,
                levelInfo.paddleSpeed(), levelInfo.paddleWidth());

        this.addCollidable(paddle);
        paddle.addToGame(this);

        // init ball
        for (int i = 0; i < levelInfo.numberOfBalls(); i++) {
            Ball ball1 = new Ball(390, 500, 6, Color.red);
            counterBalls.increase(1);
            addBalls(ball1, environment);
            this.addSprite(ball1);
            ball1.getGameEnvironment().addCollidable(paddle);
        }
        deathRegion.addHitListener(removeBalls);

        ScoreIndicator sI = new ScoreIndicator(score, rectangleScore, levelInfo);
        sI.addToGame(this);

        for (Block block : levelInfo.blocks()) {
            block.addToGame(this);
            counterBlocks.increase(1);
            BlockRemover removeBlocks = new BlockRemover(this, this.counterBlocks);
            block.addHitListener(removeBlocks);
            ScoreTrackingListener stl = new ScoreTrackingListener(score);
            block.addHitListener(stl);
            this.addCollidable(block);
        }

    }

    /**
     * removing collidables objects from list of collidable.
     *
     * @param c the collision object that removed from list.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * removing sprites objects from list of sprites.
     *
     * @param s @param s the sprite object that removed from list.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * adding balls with velocity to the game.
     *
     * @param ball the participate ball in the game.
     * @param gE   the game's environment.
     */
    public void addBalls(Ball ball, GameEnvironment gE) {
        for (Velocity v : levelInfo.initialBallVelocities()) {
            ball.setVelocity(v);
            ball.setGameEnvironment(gE);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        levelInfo.getBackground();
        this.sprites.drawAllOn(d);

        this.sprites.notifyAllTimePassed();
        if (counterBalls.getValue() == 0) {
            this.running = false;
        }

        if (counterBlocks.getValue() == 0) {
            this.running = false;
        }

        if (this.ks.isPressed("p")) {
            PauseScreen ps = new PauseScreen();
            KeyPressStoppableAnimation kpsla = new KeyPressStoppableAnimation(ks, "space", ps);
            this.runner.run(kpsla);
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * the run loop of animation.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }
}