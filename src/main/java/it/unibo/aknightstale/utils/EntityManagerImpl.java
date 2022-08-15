package it.unibo.aknightstale.utils;

import java.util.ArrayList;
import java.util.List;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public class EntityManagerImpl implements EntityManager {

    private final List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> entities;
    private CollisionManager collision;

    public EntityManagerImpl() {
        super();
        this.entities = new ArrayList<>();
    }

    public EntityManagerImpl(final List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> l) {
        super();
        this.entities = l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<List<EntityController<? super CharacterModel, ? super AnimatedEntityView>>> update() {
        return this.collision.update();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addEntity(final EntityController<? super CharacterModel, ? super AnimatedEntityView> ec) {
        if (!this.entities.contains(ec)) {
            this.entities.add(ec);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEntity(final EntityController<? super CharacterModel, ? super AnimatedEntityView> ec) {
        this.entities.stream().filter(e -> e.equals(ec)).forEach(e -> this.entities.remove(e));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> getEntities() {
        return this.entities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CollisionManager getCollisionManager() {
        return this.collision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCollisionManager(final CollisionManager collision) {
        this.collision = collision;
    }

}
