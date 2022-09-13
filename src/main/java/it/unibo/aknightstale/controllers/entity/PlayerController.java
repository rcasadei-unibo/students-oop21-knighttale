package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.Status;

public class PlayerController<M extends Character, V extends AnimatedEntityView> extends AbstractController<M, V> {

    public PlayerController(final M model, final V view, final EntityManager manager) {
        super(model, view, manager);
    }

}
