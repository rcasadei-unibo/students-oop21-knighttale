package it.unibo.aknightstale.factory;

import it.unibo.aknightstale.entity.EntityController;
import it.unibo.aknightstale.utility.EntityManager;

public interface EntityFactory {
    EntityManager getEntityManager();

    EntityController getPlayer();
}
