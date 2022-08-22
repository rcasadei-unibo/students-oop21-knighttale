package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.Entity;
import it.unibo.aknightstale.views.entity.EntityView;

public interface EntityController<M extends Entity, V extends EntityView> {
    /**
     * Gets the model of this entity.
     * 
     * @return the model.
     */
    M getModel();

    /**
     * Gets the view of this entity.
     * 
     * @return the view.
     */
    V getView();
}