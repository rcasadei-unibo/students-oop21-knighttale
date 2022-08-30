package it.unibo.aknightstale.views.map;

import it.unibo.aknightstale.models.entity.EntityType;
import javafx.scene.image.Image;

public abstract class AbstractTile implements Tile{

    final private EntityType entityType;
    private String url;
    private Image img;
    final private int index;

    private boolean collidable;


    public AbstractTile(final String url, final int index, final EntityType entityType){
        this.url = url;
        this.img = new Image(getClass().getResourceAsStream(url));
        this.index = index;
        this.entityType = entityType;
        //this.imageView.setFitHeight(100);
    }

    @Override
    public EntityType getEntityType() {
        return entityType;
    }

    public int getIndex(){
        return this.index;
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public void setWidth(final double width){
        this.img = new Image(getClass().getResourceAsStream(this.url), width, this.img.getHeight(), false, false);
    }

    @Override
    public void setHeight(final double height){
        this.img = new Image(getClass().getResourceAsStream(this.url), this.img.getWidth(), height, false, false);
    }


    @Override
    public double getWidth(){
        return this.img.getWidth();
    }

    @Override
    public double getHeight(){
        return this.img.getHeight();
    }

    @Override
    public void setCollidable(final boolean collidable){
        this.collidable = collidable;
    }

    @Override
    public boolean isCollidable(){ return this.collidable; };

    @Override
    public void resize() {

    }

    @Override
    public void reposition() {

    }

}
