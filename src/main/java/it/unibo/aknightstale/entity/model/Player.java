package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

public class Player extends BaseCharacter {
	
	private final static double MAX_HEALTH = 100.0;
	private final static double WIDE_BOUNDS = 50.0;
	private final static double HEIGHT_BOUNDS = 50.0;
	
	private final static double ATTACK_RANGE = 5.0;

	public Player(Point2D position, double dmg, double health, double speed) {
		super(position, new BoundingBox(position.getX(), position.getY(), WIDE_BOUNDS, HEIGHT_BOUNDS),
				EntityType.PLAYER, true, Direction.RIGHT, dmg, MAX_HEALTH, speed);
	}

	@Override
	public double getAttackRange() {
		return ATTACK_RANGE;
	}

	@Override
	public void attack(LifeEntity e) {
		e.setHealth(e.getHealth() - this.damage);
	}
	
	private void updatePosition(double x, double y) {
		var pos = super.getPosition();
		super.setPosition(new Point2D(pos.getX() + x, pos.getY() + y));
	}

	@Override
	public void goUp() {
		this.updatePosition(0, -speed);
	}

	@Override
	public void goDown() {
		this.updatePosition(0, speed);
	}

	@Override
	public void goLeft() {
		this.updatePosition(-speed, 0);
	}

	@Override
	public void goRight() {
		this.updatePosition(speed, 0);
	}

}