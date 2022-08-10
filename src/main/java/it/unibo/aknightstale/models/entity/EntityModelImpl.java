package it.unibo.aknightstale.models.entity;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class EntityModelImpl implements EntityModel {

	private Bounds bounds;
	private final EntityType type;
	private final boolean collidable;

	public EntityModelImpl(final Bounds bounds, final EntityType type, final boolean collidable) {
		super();
		this.bounds = bounds;
		this.type = type;
		this.collidable = collidable;
	}

	@Override
	public Point2D getPosition() {
		return new Point2D(this.bounds.getMinX(), this.bounds.getMinY());
	}

	@Override
	public void setPosition(final Point2D p) {
		this.bounds = new BoundingBox(p.getX(), p.getY(), this.bounds.getWidth(), this.bounds.getHeight());
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
