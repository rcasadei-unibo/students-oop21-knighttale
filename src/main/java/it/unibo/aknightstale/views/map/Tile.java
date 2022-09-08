package it.unibo.aknightstale.views.map;

import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.EntityView;

public interface Tile extends AnimatedEntityView {

    //Image getImage();

    int getIndex();

    EntityType getEntityType();

    void setWidth(double width);

    void setHeight(double height);

    void setCollidable(boolean collidable);

    boolean isCollidable();

    double getWidth();

    double getHeight();

    void resize();

    void reposition();
}
