package it.unibo.aknightstale.models.entity.factories;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.models.Enemy;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.utils.Point;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public interface EntityFactory {
    /**
     * Gets the entity manager.
     * 
     * @return the entity manager.
     */
    EntityManager getEntityManager();

    /**
     * Creates the player.
     * 
     * @param p The position of player.
     * @return The player.
     */
    CharacterController<Character, AnimatedEntityView> getPlayer(Point p);

    /**
     * Creates the enemy.
     * @param spawnPosition the enemy's spawn position
     * @return the enemy.
     */
    CharacterController<Character, AnimatedEntityView> getEnemy(Point spawnPosition);
}
