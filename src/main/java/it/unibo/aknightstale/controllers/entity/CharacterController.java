package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public interface CharacterController<M extends CharacterModel, V extends AnimatedEntityView> extends EntityController<M, V> {
	
	void moveRight();
	
	void moveLeft();

	void moveUp();

	void moveDown();

	void attack();

}
