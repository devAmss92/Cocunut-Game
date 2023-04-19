package org.academiadecodigo.catchcoconuts.gfx;


import org.academiadecodigo.catchcoconuts.gfx.Fruits.Fruit;
import org.academiadecodigo.catchcoconuts.gfx.Fruits.FruitFactory;
import org.academiadecodigo.catchcoconuts.gfx.Fruits.FruitType;

import org.academiadecodigo.catchcoconuts.gfx.GameMechanics.Background;
import org.academiadecodigo.catchcoconuts.gfx.GameMechanics.SoundHandler;
import org.academiadecodigo.catchcoconuts.gfx.Player.KeyboardLogic;
import org.academiadecodigo.catchcoconuts.gfx.Player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.Clip;
import java.util.concurrent.TimeUnit;

public class CatchBallGame {
    private Player player;
    private Background background;
    private int counter, size, score;
    private int lifeLines = 3;
    private Picture coverImage, life1, life2, life3, gameOver;
    private KeyboardLogic keyboardLogic;
    private FruitFactory fruitFactory;
    private Fruit f;
    private int gameState = 1;
    private Clip clip;
    private Text scoreScreenValue;


    public CatchBallGame(int size) throws InterruptedException {
        SoundHandler.PlaySound("/mixkit.wav");
        this.size = size;
        background = new Background();
        player = new Player(30);
        player.setSpeedBooster(2);
        KeyboardLogic keyboardLogic = new KeyboardLogic(player, this);
        drawLives();
        drawCover();
        startGame();
    }

    public void startGame() throws InterruptedException {

        while (getGameState() == 1) {
            System.out.println(".");
        }
        coverImageOff();
        gameLoop();
    }


    public void changeGameState(int number) {
        this.gameState = number;
    }

    public int getGameState() {
        return this.gameState;
    }

    public void drawLives() {
        life1 = new Picture(Background.BORDER, Background.BORDER, "vida.png");
        life2 = new Picture(Background.BORDER + 75, Background.BORDER, "vida.png");
        life3 = new Picture(Background.BORDER + 75 * 2, Background.BORDER, "vida.png");
        life1.draw();
        life2.draw();
        life3.draw();
    }

    public void drawCover() {
        coverImage = new Picture(Background.BORDER, Background.BORDER, "Meu projeto.png");
        coverImage.draw();
    }

    public void coverImageOff() {
        coverImage.delete();
    }

    public void drawGameOver() {
        SoundHandler.makeMeStop();
        SoundHandler.PlaySound("/super1_gameover.wav");
        gameOver = new Picture(Background.BORDER, Background.BORDER, "meu_projeto__2_.png");
        gameOver.draw();
        scoreScreenValueGameOver();
    }

    public void deleteGameOver() {
        gameOver.delete();
    }

    public void restartLives() {
        lifeLines = 3;
    }

    public void restartScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getScoreInString() {
        return String.valueOf((getScore()));
    }

    public void scoreScreenValue() {
        scoreScreenValue = new Text(50, 100, "SCORE: " + getScoreInString());
        scoreScreenValue.setColor(Color.WHITE);
        scoreScreenValue.draw();
        scoreScreenValue.grow(25, 25);
    }

    public void scoreScreenValueGameOver() {
        scoreScreenValue = new Text(500, 675, "SCORE: " + getScoreInString());
        scoreScreenValue.setColor(Color.WHITE);
        scoreScreenValue.draw();
        scoreScreenValue.grow(50, 50);
    }

    public void gameLoop() throws InterruptedException{
        scoreScreenValue();
        fruitFactory = new FruitFactory();

        while (lifeLines > 0) {

            f = fruitFactory.getNewFruit();
            f.draw();
            counter++;
            scoreScreenValue.setText("SCORE :" + getScoreInString());
            System.out.println("counter: " + counter);
            System.out.println(lifeLines);

            while (f.getY() < 800) {
                if (counter < 2) {
                    TimeUnit.MILLISECONDS.sleep(40);
                    f.move(1);
                    if ((f.getX() >= player.getX() - 10 && f.getX() <= player.getX() + 40) &&
                            (f.getY() <= player.getY() + 10 && f.getY() >= player.getY() - 10)) {
                        score += f.getPoints();
                        SoundHandler.PlaySound("/super_coin.wav");
                        f.delete();
                        break;
                    } else if (f.getY() > 799 && f.getFruitType() != FruitType.LAPAPAYA) {
                        SoundHandler.PlaySound("/lost-closing.wav");
                        lifeLines--;
                        if (lifeLines == 2) {
                            life3.delete();
                        } else if (lifeLines == 1) {
                            life2.delete();
                        } else {
                            life1.delete();
                            drawGameOver();
                            gameState = 3;
                        }
                    }
                } else if (counter < 8) {
                    TimeUnit.MILLISECONDS.sleep(50);
                    f.move(1);
                    if ((f.getX() >= player.getX() - 10 && f.getX() <= player.getX() + 40) &&
                            (f.getY() <= player.getY() + 10 && f.getY() >= player.getY() - 10)) {
                        score += f.getPoints();
                        SoundHandler.PlaySound("/super_coin.wav");
                        f.delete();
                        break;
                    } else if (f.getY() > 799 && f.getFruitType() != FruitType.LAPAPAYA) {
                        SoundHandler.PlaySound("/lost-closing.wav");
                        lifeLines--;
                        if (lifeLines == 2) {
                            life3.delete();
                        } else if (lifeLines == 1) {
                            life2.delete();
                        } else {
                            life1.delete();
                            drawGameOver();
                            gameState = 3;
                        }
                    }
                } else if (counter < 16) {
                    TimeUnit.MILLISECONDS.sleep(40);
                    f.move(1);
                    if ((f.getX() >= player.getX() - 10 && f.getX() <= player.getX() + 40) &&
                            (f.getY() <= player.getY() + 10 && f.getY() >= player.getY() - 10)) {
                        score += f.getPoints();
                        SoundHandler.PlaySound("/super_coin.wav");
                        f.delete();
                        break;
                    } else if (f.getY() > 799 && f.getFruitType() != FruitType.LAPAPAYA) {
                        SoundHandler.PlaySound("/lost-closing.wav");
                        lifeLines--;
                        if (lifeLines == 2) {
                            life3.delete();
                        } else if (lifeLines == 1) {
                            life2.delete();
                        } else {
                            life1.delete();
                            drawGameOver();
                            gameState = 3;
                        }
                    }

                } else if (counter < 31) {
                    TimeUnit.MILLISECONDS.sleep(30);
                    f.move(1);
                    if ((f.getX() >= player.getX() - 10 && f.getX() <= player.getX() + 40) &&
                            (f.getY() <= player.getY() + 10 && f.getY() >= player.getY() - 10)) {
                        SoundHandler.PlaySound("/super_coin.wav");
                        score += f.getPoints();
                        f.delete();
                        break;
                    } else if (f.getY() > 799 && f.getFruitType() != FruitType.LAPAPAYA) {
                        SoundHandler.PlaySound("/lost-closing.wav");
                        lifeLines--;
                        if (lifeLines == 2) {
                            life3.delete();
                        } else if (lifeLines == 1) {
                            life2.delete();
                        } else {
                            life1.delete();
                            drawGameOver();
                            gameState = 3;
                        }
                    }
                    drawGameOver();
                }

            }
        }
    }
}



