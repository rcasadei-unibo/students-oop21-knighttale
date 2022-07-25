package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.Direction;

public interface MovebleEntity extends EntityModel{
	/**
	 * Get entity's speed
	 * 
	 * @return	The entity's speed
	 */
    double getSpeed();

    /**
     * Set the entity's speed
     * 
     * @param speed	The new entity's speed
     */
    void setSpeed(double speed);

    /**
     * Get entity's direction
     * 
     * @return	The entity's direction
     */
    Direction getDirection();

    /**
     * Move up entity
     */
    void goUp();
    
    /**
     * Move down entity
     */
    void goDown();
    
    /**
     * Move left entity
     */
    void goLeft();
    
    /**
     * Move right entity
     */
    void goRight();
}
