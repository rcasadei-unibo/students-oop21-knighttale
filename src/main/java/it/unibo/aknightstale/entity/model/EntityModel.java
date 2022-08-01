package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public interface EntityModel {
	
    Point2D getPosition();

    void setPosition(Point2D p);

    Bounds getBounds();

    EntityType getType();

    Boolean isCollidable();
}
