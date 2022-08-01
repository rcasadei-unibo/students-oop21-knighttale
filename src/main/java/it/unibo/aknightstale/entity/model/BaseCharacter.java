package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public abstract class BaseCharacter extends EntityModelImpl implements Character {
	
	protected double damage;
	protected double health;
	protected double speed;
	protected Direction direction;
	
	public BaseCharacter(Point2D position, Bounds bounds, EntityType type, boolean collidable,
						Direction dir, double dmg, double health, double speed) {
		super(position, bounds, type, collidable);
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
	public void setDamage(double dmg) {
		this.damage = dmg;
	}

	@Override
	public abstract double getAttackRange();

	@Override
	public abstract void attack(LifeEntity e);

	@Override
	public void setHealth(double health) {
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
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public void setDirection(Direction dir) {
		this.direction = dir;
	}

	@Override
	public abstract void goUp();

	@Override
	public abstract void goDown();

	@Override
	public abstract void goLeft();

	@Override
	public abstract void goRight();

}
