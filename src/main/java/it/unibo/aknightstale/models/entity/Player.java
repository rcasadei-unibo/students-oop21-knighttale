package it.unibo.aknightstale.models.entity;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

public class Player extends BaseCharacter {

	final static double WIDTH_BOUNDS = 50.0;
	final static double HEIGHT_BOUNDS = 50.0;
	final static double DAMAGE = 25.0;
	final static double MAX_HEALTH = 100.0;
	final static double SPEED = 1.0;

    final static double ATTACK_RANGE = 5.0;

	public Player(final Point2D position) {
		super(new BoundingBox(position.getX(), position.getY(), WIDTH_BOUNDS, HEIGHT_BOUNDS),
				EntityType.PLAYER, false, Direction.RIGHT, DAMAGE, MAX_HEALTH, SPEED);
	}

	@Override
	public double getAttackRange() {
		return ATTACK_RANGE;
	}

	@Override
	public void attack(final LifeEntity e) {
		e.setHealth(e.getHealth() - this.damage);
	}

}
