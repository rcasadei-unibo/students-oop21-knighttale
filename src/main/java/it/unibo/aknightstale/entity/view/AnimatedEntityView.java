package it.unibo.aknightstale.entity.view;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.Status;

public interface AnimatedEntityView extends EntityView {
	
	/**
	 * Set the entity status
	 * 
	 * @param s	The new status of entity
	 */
	void setStatus(Status s);
	
	/**
	 * Update the new entity image at each frame
	 * 
	 * @param dir	The entity direction
	 */
    void update(Direction dir);

}
