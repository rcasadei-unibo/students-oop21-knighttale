package it.unibo.aknightstale.utility;


import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.EntityController;

public interface CollisionManager {
    EntityController[] checkCollision(EntityController ec);

    Direction[] canMove(EntityController ec); //NOPMD - suppressed LinguisticNaming - Temporary - TODO: find a better name for this method
}
