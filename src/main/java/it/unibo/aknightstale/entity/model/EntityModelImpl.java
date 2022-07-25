package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class EntityModelImpl implements EntityModel {
	
	private Point2D position;
	private Bounds bounds;
	private final EntityType type;
	private final boolean collidable;

	public EntityModelImpl(Point2D position, Bounds bounds, EntityType type, boolean collidable) {
		super();
		this.position = position;
		this.bounds = bounds;
		this.type = type;
		this.collidable = collidable;
	}

	@Override
	public Point2D getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Point2D p) {
		this.position = p;
	}

	@Override
	public Bounds getBounds() {
		return this.bounds;
	}

	@Override
	public EntityType getType() {
		return this.type;
	}

	@Override
	public Boolean isCollidable() {
		return this.collidable;
	}

}
