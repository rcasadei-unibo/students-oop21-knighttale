package it.unibo.aknightstale.utils;

import java.util.List;

<<<<<<< HEAD:src/main/java/it/unibo/aknightstale/utility/EntityManager.java
import it.unibo.aknightstale.entity.controller.EntityController;
<<<<<<< HEAD:src/main/java/it/unibo/aknightstale/utils/EntityManager.java
=======
import it.unibo.aknightstale.models.entity.EntityController;
>>>>>>> main:src/main/java/it/unibo/aknightstale/utils/EntityManager.java
=======
import it.unibo.aknightstale.entity.model.CharacterModel;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;
>>>>>>> entityManager:src/main/java/it/unibo/aknightstale/utility/EntityManager.java

public interface EntityManager {
	/**
	 * Check the collisions between all characters
	 * 
	 * @return	A list of lists of characters who colliding
	 */
	List<List<EntityController<? super CharacterModel, ? super AnimatedEntityView>>> update();

    /**
     * Add a new entity in the entity list if it is not already present
     * 
     * @param ec	The new entity that will be added if it is not already present
     */
    void addEntity(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec);
    
    /**
     * Remove a entity from the entity list if it is present
     * 
     * @param ec	The entity will be removed if it is present
     */
    void removeEntity(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec);

    /**
     * Get the entity list
     * 
     * @return The entity list
     */
    List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> getEntities();
    
    /**
     * Get the collision manager
     * 
     * @return	The collision manager
     */
    CollisionManager getCollisionManager();
    
    /**
     * Set the collision manager
     * 
     * @param The collision manager
     */
    void setCollisionManager(CollisionManager collision);
}
