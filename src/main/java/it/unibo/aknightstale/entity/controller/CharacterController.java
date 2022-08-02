package it.unibo.aknightstale.entity.controller;

import it.unibo.aknightstale.entity.model.Character;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;

public interface CharacterController<M extends Character, V extends AnimatedEntityView> extends EntityController<M, V> {
	
	void moveRight();
	
	void moveLeft();

	void moveUp();

	void moveDown();

	void attack();

}
