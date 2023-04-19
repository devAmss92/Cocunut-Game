package org.academiadecodigo.catchcoconuts.gfx.Fruits;

public enum FruitType {

    LOSCOCOS("img_1(1).png",45),
    LAPAPAYA("LaPapaya.png",-30),
    LABANANA("Labanana.png",20),
    LAPINNAPLE("Lapinapple.png",25);


    private String picture;
    private int points;
    FruitType(String picture,int points){
        this.picture = picture;
        this.points = points;
    }

    public String getPicture() {
        return picture;
    }
    public int getPoints(){
        return points;
    }

}