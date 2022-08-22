package it.unibo.aknightstale.controllers.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

    @SuppressFBWarnings("EI_EXPOSE_REP2")       //impossible clone the arguments because of generic typing
    public EntityControllerImpl(final M model, final V view) {
        super();
        this.model = model;
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressFBWarnings("EI_EXPOSE_REP")       //impossible clone the model because of generic typing
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
