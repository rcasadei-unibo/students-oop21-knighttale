package it.unibo.aknightstale.models.entity;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

public class Player extends BaseCharacter {
	
	private final static double WIDTH_BOUNDS = 50.0;
	private final static double HEIGHT_BOUNDS = 50.0;
	private final static double DAMAGE = 25.0;
	private final static double MAX_HEALTH = 100.0;
	private final static double SPEED = 1.0;

	private final static double ATTACK_RANGE = 5.0;

	public Player(Point2D position, double dmg, double health, double speed) {
		super(new BoundingBox(position.getX(), position.getY(), WIDTH_BOUNDS, HEIGHT_BOUNDS),
				EntityType.PLAYER, false, Direction.RIGHT, DAMAGE, MAX_HEALTH, SPEED);
	}

	@Override
	public double getAttackRange() {
		return ATTACK_RANGE;
	}

	@Override
	public void attack(LifeEntity e) {
		e.setHealth(e.getHealth() - this.damage);
	}

}
