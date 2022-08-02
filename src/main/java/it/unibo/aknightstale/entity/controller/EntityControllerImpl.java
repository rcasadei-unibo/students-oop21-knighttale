package it.unibo.aknightstale.entity.controller;

public class EntityControllerImpl<M, V> implements EntityController<M, V> {
	
	private final M model;
	private final V view;
	
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
