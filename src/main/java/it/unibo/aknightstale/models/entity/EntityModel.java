package it.unibo.aknightstale.models.entity;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public interface EntityModel {
    Point2D getPosition();

    void setPosition(Point2D p);

    Bounds getBounds();

    EntityType getType();

    Boolean isCollidable();
}
