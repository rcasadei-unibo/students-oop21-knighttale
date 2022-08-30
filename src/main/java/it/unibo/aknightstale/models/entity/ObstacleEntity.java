package it.unibo.aknightstale.models.entity;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class ObstacleEntity implements Entity{

    private Point2D position;

    public ObstacleEntity(final Point2D position){
        this.position = position;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(final Point2D p) {
        this.position = p;
    }

    @Override
    public Bounds getBounds() {
        return null;
    }

    @Override
    public EntityType getType() {
        return EntityType.OBSTACLE;
    }

    @Override
    public Boolean isCollidable() {
        return true;
    }
}
