package it.unibo.aknightstale.models.entity.factories;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.controllers.entity.EnemyController;
import it.unibo.aknightstale.controllers.entity.PlayerController;
import it.unibo.aknightstale.models.Enemy;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Player;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.utils.EntityManagerImpl;
import it.unibo.aknightstale.utils.Point2D;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.EnemyView;
import it.unibo.aknightstale.views.entity.PlayerView;

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
    @SuppressFBWarnings("EI_EXPOSE_REP")       //must return a reference because it will be modified
    @Override
    public EntityManager getEntityManager() {
        return this.manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CharacterController<Character, AnimatedEntityView> getPlayer() {
        final var player = new PlayerController<Character, AnimatedEntityView>(new Player(SPAWN_PLAYER),
                new PlayerView(), getEntityManager());
        this.manager.addEntity(player);
        return player;
    }

    @Override
    public CharacterController<Character, AnimatedEntityView> getEnemy(final int x, final int y) {

        Enemy enemyModel = new Enemy(new Point2D(x, y));
        EnemyView enemyView = new EnemyView();
        new EnemyController(enemyModel, enemyView, new EntityManagerImpl());

        final var enemy = new PlayerController<Character, AnimatedEntityView>(new Player(SPAWN_PLAYER),
                new PlayerView(), getEntityManager());
        this.manager.addEntity(enemy);
        return enemy;
    }



}
