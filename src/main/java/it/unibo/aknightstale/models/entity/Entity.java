package it.unibo.aknightstale.models.entity;

import it.unibo.aknightstale.utils.Borders;
import it.unibo.aknightstale.utils.Point2D;

public interface Entity {
    /**
     * Gets the entity position.
     * 
     * @return the entity position.
     */
    Point2D getPosition();

    /**
     * Sets the entity position.
     * 
     * @param p the new position.
     */
    void setPosition(Point2D p);

    /**
     * Gets the entity bounds.
     * 
     * @return the entity bounds.
     */
    Borders getBorders();

    /**
     * Gets the entity type.
     * 
     * @return the entity type.
     */
    EntityType getType();

    /**
     * Checks if the entity can have collisions.
     * 
     * @return true if entity can have collisions, false otherwise.
     */
    Boolean isCollidable();
}
