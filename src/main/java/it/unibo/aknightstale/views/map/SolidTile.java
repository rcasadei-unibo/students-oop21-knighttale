package it.unibo.aknightstale.views.map;

import it.unibo.aknightstale.models.entity.EntityType;

import java.awt.*;

public class SolidTile extends AbstractTile {

    private Rectangle solidArea;

    public SolidTile(String url, int index, final EntityType entityType/*, final int x, final int y*/) {
        super(url, index, entityType);
        super.setCollidable(true);
        this.solidArea = new Rectangle(/*x, y, */(int) super.getWidth(), (int) super.getHeight());
    }



}
