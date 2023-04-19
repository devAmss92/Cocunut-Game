package org.academiadecodigo.catchcoconuts.gfx.Player;

import org.academiadecodigo.catchcoconuts.gfx.GameMechanics.Background;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    public static final int CELLSIZE = 25;
    Picture playerModel;
    private int row;
    private int col;
    private int speedBooster = 1;

    public Player(int col) {
        this.col = col;
        row = rowToY(31);
        playerModel = new Picture(colToX(col), row, "meu_projeto.png");
        playerModel.draw();

    }
    public void moveRight() {
        if (playerModel.getX() < 900) {
            playerModel.translate(speedBooster * CELLSIZE, 0);
            col += speedBooster;
            playerModel.delete();
            playerModel = new Picture(colToX(col), row, "meu_projeto.png");
            playerModel.draw();
        }
    }
    public void moveLeft() {
        if (playerModel.getX() > colToX(14)) {
            playerModel.translate(-speedBooster * CELLSIZE, 0);
            col -= speedBooster;
            playerModel.delete();
            playerModel = new Picture(colToX(col), row, "boneco_inverted(1).png");
            playerModel.draw();
        }
    }

    public int getX(){
        return playerModel.getX();
    }
    public int getY(){
        return playerModel.getY();
    }
    public int colToX(int col) {
        int x = (col * CELLSIZE) + Background.BORDER;
        return x;
    }
    public int rowToY(int row) {
        int y = (row * CELLSIZE) + Background.BORDER;
        return y;
    }
    public void setSpeedBooster(int speedBooster) {
        this.speedBooster = speedBooster;
    }

}
