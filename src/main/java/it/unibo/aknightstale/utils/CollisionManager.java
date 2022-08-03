package it.unibo.aknightstale.utils;


import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.EntityController;

public interface CollisionManager {
    EntityController[] checkCollision(EntityController ec);

    Direction[] canMove(EntityController ec); //NOPMD - suppressed LinguisticNaming - Temporary - TODO: find a better name for this method
}
