package it.unibo.aknightstale.entity.controller;

public interface EntityController<M,V> {
	
    M getModel();

    V getView();
}
