package it.unibo.aknightstale.entity.view;

import it.unibo.aknightstale.entity.Direction;

public interface AnimatedEntityView extends EntityView {
	
    void update(Direction d);
    
}
