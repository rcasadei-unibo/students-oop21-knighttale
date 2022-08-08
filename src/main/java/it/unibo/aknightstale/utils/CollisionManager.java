package it.unibo.aknightstale.utils;


import java.util.List;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public interface CollisionManager {
	
	List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> checkCollision(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec);

    List<Direction> canMove(EntityController<? extends CharacterModel, ? extends AnimatedEntityView> ec);
    
    List<List<EntityController<? super CharacterModel, ? super AnimatedEntityView>>> update();
	
}
