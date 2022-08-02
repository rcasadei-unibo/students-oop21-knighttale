package it.unibo.aknightstale.entity.controller;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.Status;
import it.unibo.aknightstale.entity.model.Character;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;
import it.unibo.aknightstale.utility.EntityManager;

public class PlayerController<M extends Character, V extends AnimatedEntityView> extends AbstractController<M, V> {

	public PlayerController(M model, V view, EntityManager manager) {
		super(model, view, manager);
	}

	@Override
	protected void move(Direction dir) {
		super.model.setDirection(dir);
		super.view.setStatus(Status.WALK);
		super.view.update(super.model.getDirection());
	}

	@Override
	public void attack() {
		
	}

}
