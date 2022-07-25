package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class MovebleEntityImpl extends EntityModelImpl implements MovebleEntity {

	private double speed;
	private Direction direction;

	public MovebleEntityImpl(Point2D position, Bounds bounds, EntityType type, boolean collidable, double speed, Direction dir) {
		super(position, bounds, type, collidable);
		this.speed = speed;
		this.direction = dir;
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
