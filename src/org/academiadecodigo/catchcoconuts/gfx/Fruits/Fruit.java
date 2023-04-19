package org.academiadecodigo.catchcoconuts.gfx.Fruits;

import org.academiadecodigo.catchcoconuts.gfx.GameMechanics.Background;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Fruit {

    private int col;
    private int row;
    private FruitType fruit;
    private int random;
    private int goodRandom;
    private Picture fruitPicture;
    public int giveMeAGoodRandom() {
        random = (int) Math.ceil(Math.random() * 900);
        if ((random > 350) && (random % 25 == 0)) {
            goodRandom = random;
            return goodRandom;
        }
        return giveMeAGoodRandom();
    }

    public Fruit(FruitType fruit) {
        this.fruit = fruit;
        row = 0;
        fruitPicture = new Picture(giveMeAGoodRandom(), row, fruit.getPicture());
        col = fruitPicture.getX() / Background.CELLSIZE;
    }
    public int getPoints(){
        return fruit.getPoints();
    }
    public int getX(){
        return fruitPicture.getX();
    }
    public int getY(){
        return fruitPicture.getY();
    }

    public void draw() {
        fruitPicture.draw();
    }

    public void move(int units) {
        fruitPicture.translate(0, Background.CELLSIZE * units);
        row += units;
    }
    public void delete(){
        fruitPicture.delete();
    }
    public FruitType getFruitType(){
        return fruit;
    }

}
