package org.academiadecodigo.catchcoconuts.gfx.Player;


import org.academiadecodigo.catchcoconuts.gfx.CatchBallGame;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;
    private CatchBallGame game;


    public KeyboardLogic(Player player, CatchBallGame game) {
        this.player = player;
        this.game = game;
        init();

    }

    public void init() {

        keyboard = new Keyboard(this);
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);


        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_ENTER);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(quit);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (game.getGameState() == 2) {
                    player.moveRight();
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (game.getGameState() == 2) {
                    player.moveLeft();
                }
                break;
            case KeyboardEvent.KEY_ENTER:
                if (game.getGameState() == 1 || game.getGameState() ==3) {
                    game.changeGameState(2);
                }
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
