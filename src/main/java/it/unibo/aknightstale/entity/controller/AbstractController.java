package it.unibo.aknightstale.entity.controller;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.model.Character;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;

public abstract class AbstractController<M extends Character, V extends AnimatedEntityView> extends EntityControllerImpl<M, V> implements CharacterController<M, V> {
	
	public AbstractController(M model, V view) {
		super(model, view);
	}
	
	protected abstract void move(Direction dir);

	@Override
	public void moveRight() {
		this.model.goRight();
		move(Direction.RIGHT);
	}

	@Override
	public void moveLeft() {
		this.model.goLeft();
		move(Direction.LEFT);
	}

	@Override
	public void moveUp() {
		this.model.goUp();
		move(Direction.UP);
	}

	@Override
	public void moveDown() {
		this.model.goDown();
		move(Direction.DOWN);
	}

	@Override
	public abstract void attack();

}
