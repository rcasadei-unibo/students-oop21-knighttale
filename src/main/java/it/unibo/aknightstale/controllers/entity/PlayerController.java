package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.Status;

public class PlayerController<M extends CharacterModel, V extends AnimatedEntityView> extends AbstractController<M, V> {
	
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
		.filter(ec -> ec.getModel() instanceof CharacterModel)
		.forEach(e -> {
			var model = (CharacterModel) e.getModel();
			this.model.attack(model);
		});
	this.view.setStatus(Status.ATTACK);
	this.view.update(this.model.getDirection());		
	}

}
