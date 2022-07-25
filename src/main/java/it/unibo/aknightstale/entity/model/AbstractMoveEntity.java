package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

abstract class AbstractMoveEntity extends MovebleEntityImpl implements LifeEntity, AttackEntity {
	
	final static double RANGE = 5;
	
	private double damage;
	private double health;

	protected AbstractMoveEntity(Point2D position, Bounds bounds, EntityType type, boolean collidable, double speed,
			Direction dir, double damage, double health) {
		super(position, bounds, type, collidable, speed, dir);
		this.damage = damage;
		this.health = health;
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
	public double getAttackRange() {
		return this.RANGE;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	}

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
		return this.health == 0;
	}

}
