package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;

public interface AnimatedEntityView extends EntityView {
	
	void setStatus(Status s);
	
    void update(Direction d);
    
}
