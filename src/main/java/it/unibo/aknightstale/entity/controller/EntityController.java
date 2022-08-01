package it.unibo.aknightstale.entity.controller;

import it.unibo.aknightstale.entity.model.EntityModel;
import it.unibo.aknightstale.entity.view.EntityView;

public interface EntityController {
	
    EntityModel getModel();

    EntityView getView();
}
