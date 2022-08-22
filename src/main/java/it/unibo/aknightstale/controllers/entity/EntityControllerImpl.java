package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.Entity;
import it.unibo.aknightstale.views.entity.EntityView;

public class EntityControllerImpl<M extends Entity, V extends EntityView> implements EntityController<M, V> {

    /**
     * The entity model.
     */
    private final M model;
    /**
     * The entity view.
     */
    private final V view;

    public EntityControllerImpl(final M model, final V view) {
        super();
        this.model = model;
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public M getModel() {
        return this.model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V getView() {
        return this.view;
    }

}
