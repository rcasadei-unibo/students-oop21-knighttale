package it.unibo.aknightstale.views.map;

import javafx.scene.image.Image;

public class Tile {


    private String url;
    private Image img;
    final private int index;

    public Tile(final String url, final int index){
        this.url = url;
        this.img = new Image(getClass().getResourceAsStream(url));
        this.index = index;
        //this.imageView.setFitHeight(100);
    }

    public int getIndex(){
        return this.index;
    }

    public Image getImage() {
        return img;
    }

    public void setWidth(final double width){
        this.img = new Image(getClass().getResourceAsStream(this.url), width, this.img.getHeight(), false, false);
    }

    public void setHeight(final double height){
        this.img = new Image(getClass().getResourceAsStream(this.url), this.img.getWidth(), height, false, false);
    }

}
