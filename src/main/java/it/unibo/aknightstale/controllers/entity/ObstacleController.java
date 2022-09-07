package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public class ObstacleController<M extends Character, V extends AnimatedEntityView> extends EntityControllerImpl<M, V> {

    public ObstacleController(final M model, final V view) {
        super(model, view);
    }
}