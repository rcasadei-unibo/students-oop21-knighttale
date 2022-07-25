package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public interface EntityModel {
	/**
	 * Get entity's position
	 * 
	 * @return	The entity's position
	 */
    Point2D getPosition();

    /**
     * Set entity's position
     * 
     * @param p	The new position
     */
    void setPosition(Point2D p);

    /**
     * Get entity's bounds
     * 
     * @return	The entity's bounds
     */
    Bounds getBounds();

    /**
     * Get entity's type
     * 
     * @return	The entity's type
     */
    EntityType getType();

    /**
     * Check if this entity is collidable
     * 
     * @return	true if entity is collidable, false otherwise
     */
    Boolean isCollidable();
}
