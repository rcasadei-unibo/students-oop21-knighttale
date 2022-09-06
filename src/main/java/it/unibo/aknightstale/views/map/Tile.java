package it.unibo.aknightstale.views.map;

import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.views.entity.EntityView;

public interface Tile extends EntityView {

    //Image getImage();

    int getIndex();

    EntityType getEntityType();

    void setWidth(final double width);

    void setHeight(final double height);

    void setCollidable(final boolean collidable);

    boolean isCollidable();

    double getWidth();

    double getHeight();

    void resize();

    void reposition();
}
