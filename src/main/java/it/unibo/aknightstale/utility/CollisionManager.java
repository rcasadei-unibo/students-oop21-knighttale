package it.unibo.aknightstale.utility;


import java.util.List;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.controller.EntityController;
import it.unibo.aknightstale.entity.model.CharacterModel;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;

public interface CollisionManager {
	
    List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> checkCollision(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec);

    List<Direction> canMove(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec);
    
    List<List<EntityController<? super CharacterModel, ? super AnimatedEntityView>>> update();
}
