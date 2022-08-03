package it.unibo.aknightstale.utility;


import java.util.List;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.controller.EntityController;
import it.unibo.aknightstale.entity.model.EntityModel;
import it.unibo.aknightstale.entity.view.EntityView;

public interface CollisionManager {
	
    List<EntityController<? extends EntityModel, ? extends EntityView>> checkCollision(EntityController<? extends EntityModel, ? extends EntityView> ec);

    List<Direction> canMove(EntityController<? extends EntityModel, ? extends EntityView> ec);
}
