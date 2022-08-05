package it.unibo.aknightstale.utils;


import java.util.List;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.EntityModel;
import it.unibo.aknightstale.views.entity.EntityView;

public interface CollisionManager {
	
	List<EntityController<? extends EntityModel, ? extends EntityView>> checkCollision(EntityController<? extends EntityModel, ? extends EntityView> ec);

	List<Direction> canMove(EntityController<? extends EntityModel, ? extends EntityView> ec);
	
}
