package it.unibo.aknightstale.models.entity;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public abstract class BaseCharacter extends EntityModelImpl implements CharacterModel {

	protected double damage;
	protected double health;
	protected double speed;
	protected Direction direction;
	
	public BaseCharacter(final Bounds bounds, final EntityType type, final boolean collidable,
						final Direction dir, final double dmg, final double health, final double speed) {
		super(bounds, type, collidable);
		this.damage = dmg;
		this.health = health;
		this.speed = speed;
		this.direction = dir;
	}

	@Override
	public double getDamage() {
		return this.damage;
	}

	@Override
	public void setDamage(final double dmg) {
		this.damage = dmg;
	}

	@Override
	public abstract double getAttackRange();

	@Override
	public abstract void attack(final LifeEntity e);

	@Override
	public void setHealth(final double health) {
		this.health = health;
	}

	@Override
	public double getHealth() {
		return this.health;
	}

	@Override
	public boolean isDead() {
		return this.health <= 0;
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}

	@Override
	public void setSpeed(final double speed) {
		this.speed = speed;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public void setDirection(final Direction dir) {
		this.direction = dir;
	}
	
	private void updatePosition(final double x, final double y) {
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
