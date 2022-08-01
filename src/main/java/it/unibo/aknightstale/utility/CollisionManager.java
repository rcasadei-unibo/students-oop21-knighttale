package it.unibo.aknightstale.utility;


import java.util.List;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.controller.EntityController;

public interface CollisionManager {
	
    List<EntityController> checkCollision(EntityController ec);

    List<Direction> canMove(EntityController ec);
}
