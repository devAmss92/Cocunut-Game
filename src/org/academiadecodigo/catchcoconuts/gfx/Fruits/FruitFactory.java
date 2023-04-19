package org.academiadecodigo.catchcoconuts.gfx.Fruits;

public class FruitFactory {

    private Fruit fruit;

    public Fruit getNewFruit(){

        int random = (int) (Math.random()*FruitType.values().length);
        FruitType fruitType = FruitType.values()[random];

        switch (fruitType){
            case LABANANA:
                fruit = new Banana(FruitType.LABANANA);
                break;
            case LAPAPAYA:
                fruit = new Papaya(FruitType.LAPAPAYA);
                break;
            case LAPINNAPLE:
                fruit = new Pineapple(FruitType.LAPINNAPLE);
                break;
            case LOSCOCOS:
                fruit = new Coconut(FruitType.LOSCOCOS);
                break;
        }
        return fruit;
    }
}
