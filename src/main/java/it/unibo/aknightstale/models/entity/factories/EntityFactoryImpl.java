package it.unibo.aknightstale.models.entity.factories;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.controllers.entity.PlayerController;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Player;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.utils.EntityManagerImpl;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.PlayerView;
import javafx.geometry.Point2D;

public class EntityFactoryImpl implements EntityFactory {

    static final Point2D SPAWN_PLAYER = new Point2D(100, 100);

    private final EntityManager manager;

    public EntityFactoryImpl() {
        super();
        this.manager = new EntityManagerImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityManager getEntityManager() {
        return this.manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CharacterController<? extends Character, ? extends AnimatedEntityView> getPlayer() {
        final var player = new PlayerController<Character, AnimatedEntityView>(new Player(SPAWN_PLAYER),
                new PlayerView(), getEntityManager());
        this.manager.addEntity(player);
        return player;
    }

}
