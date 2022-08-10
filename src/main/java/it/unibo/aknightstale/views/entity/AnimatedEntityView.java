package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;

public interface AnimatedEntityView extends EntityView {
	/**
	 * Sets the entity status.
	 * 
	 * @param s	the new status.
	 */
	void setStatus(Status s);
	/**
	 * updates the image of the entity according to the direction in which it moves.
	 * @param d	the direction.
	 */
    void update(Direction d);

}
