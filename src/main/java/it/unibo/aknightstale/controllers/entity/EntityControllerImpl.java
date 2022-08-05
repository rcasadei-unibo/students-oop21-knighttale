package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.EntityModel;
import it.unibo.aknightstale.views.entity.EntityView;

public class EntityControllerImpl<M extends EntityModel, V extends EntityView> implements EntityController<M, V> {
	
	protected final M model;
	protected final V view;
	
	public EntityControllerImpl(M model, V view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public M getModel() {
		return this.model;
	}

	@Override
	public V getView() {
		return this.view;
	}

}
