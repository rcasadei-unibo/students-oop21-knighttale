package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.EntityModel;
import it.unibo.aknightstale.views.entity.EntityView;

public interface EntityController<M extends EntityModel,V extends EntityView> {
	
    M getModel();

    V getView();
}
