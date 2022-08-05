package it.unibo.aknightstale.models.entity.factories;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public interface EntityFactory {
    EntityManager getEntityManager();

    CharacterController<? extends CharacterModel, ? extends AnimatedEntityView> getPlayer();
}
