package it.unibo.aknightstale.utils;

import java.util.List;

<<<<<<< HEAD:src/main/java/it/unibo/aknightstale/utility/EntityManager.java
import it.unibo.aknightstale.entity.controller.EntityController;
=======
import it.unibo.aknightstale.models.entity.EntityController;
>>>>>>> main:src/main/java/it/unibo/aknightstale/utils/EntityManager.java

public interface EntityManager {
	
    void update();

    /**
     * Add a new entity in the entity list if it is not already present
     * 
     * @param ec	The new entity that will be added if it is not already present
     */
    void addEntity(EntityController ec);
    
    /**
     * Remove a entity from the entity list if it is present
     * 
     * @param ec	The entity will be removed if it is present
     */
    void removeEntity(EntityController ec);

    /**
     * Get the entity list
     * 
     * @return The entity list
     */
    List<EntityController> getEntities();
    
    /**
     * Get the collision manager
     * 
     * @return	The collision manager
     */
    CollisionManager getCollisionManager();
}
