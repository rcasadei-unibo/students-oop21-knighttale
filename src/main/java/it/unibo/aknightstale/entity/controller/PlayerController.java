package it.unibo.aknightstale.entity.controller;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.Status;
import it.unibo.aknightstale.entity.model.Character;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;
import it.unibo.aknightstale.utility.EntityManager;

public class PlayerController<M extends Character, V extends AnimatedEntityView> extends AbstractController<M, V> {
	
	private final EntityManager manager;

	public PlayerController(M model, V view, EntityManager manager) {
		super(model, view);
		this.manager = manager;
	}

	@Override
	protected void move(Direction dir) {
		super.model.setDirection(dir);
		super.view.setStatus(Status.WALK);
		super.view.update(super.model.getDirection());
	}

	@Override
	public void attack() {
		this.manager.getEntities()
		.stream()
		.filter(ec -> {
			var e = ec.getModel();
			switch (this.model.getDirection()) {
			case RIGHT:
				return e.getPosition().getX() <= this.model.getPosition().getX() + this.model.getAttackRange() &&
						e.getPosition().getX() >= this.model.getPosition().getX();
			case LEFT:
				return e.getPosition().getX() >= this.model.getPosition().getX() - this.model.getAttackRange() &&
						e.getPosition().getX() <= this.model.getPosition().getX();
			case UP:
				return e.getPosition().getY() >= this.model.getPosition().getY() - this.model.getAttackRange() &&
						e.getPosition().getY() <= this.model.getPosition().getY();
			case DOWN:
				return e.getPosition().getY() <= this.model.getPosition().getY() + this.model.getAttackRange() &&
						e.getPosition().getY() >= this.model.getPosition().getY();
			}
			return true;
		})
		.filter(ec -> ec.getModel() instanceof Character)
		.forEach(e -> {
			var model = (Character) e.getModel();
			this.model.attack(model);
		});
	this.view.setStatus(Status.ATTACK);
	this.view.update(this.model.getDirection());		
	}

}
