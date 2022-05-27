package it.unibo.aknightstale.utility;


import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.EntityController;

public interface CollisionManager {
    EntityController[] checkCollision(EntityController ec);

    Direction[] canMove(EntityController ec);
}
