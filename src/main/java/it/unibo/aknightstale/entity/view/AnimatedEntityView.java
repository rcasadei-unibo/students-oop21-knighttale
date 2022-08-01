package it.unibo.aknightstale.entity.view;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.Status;

public interface AnimatedEntityView extends EntityView {
	
	void setStatus(Status s);
	
    void update(Direction d);
    
}
