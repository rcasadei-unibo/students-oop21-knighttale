package it.unibo.aknightstale.models.entity.factories;

import it.unibo.aknightstale.models.entity.EntityController;
import it.unibo.aknightstale.utils.EntityManager;

public interface EntityFactory {
    EntityManager getEntityManager();

    EntityController getPlayer();
}
