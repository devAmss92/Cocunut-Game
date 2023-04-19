package org.academiadecodigo.catchcoconuts.gfx.GameMechanics;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Background {
    public static final int CELLSIZE = 25;
    public static final int BORDER = 10;
    private Picture background;

    public Background() {
        background = new Picture(BORDER, BORDER, "Safeimagekit-resized-img(1).png");
        background.draw();
    }
}
