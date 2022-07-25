package it.unibo.aknightstale.factory;

import it.unibo.aknightstale.entity.model.MovebleEntity;
import it.unibo.aknightstale.utility.EntityManager;

public interface EntityFactory {
	
    EntityManager getEntityManager();

    MovebleEntity getPlayer();
}
