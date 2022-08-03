package it.unibo.aknightstale.utility;

import java.util.List;

import it.unibo.aknightstale.entity.controller.EntityController;

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
