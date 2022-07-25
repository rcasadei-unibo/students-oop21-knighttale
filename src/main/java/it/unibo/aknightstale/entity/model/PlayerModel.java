package it.unibo.aknightstale.entity.model;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.EntityType;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class PlayerModel extends AbstractMoveEntity {

	public PlayerModel(Point2D position, Bounds bounds, EntityType type, boolean collidable, double speed,
			Direction dir, double damage, double health) {
		super(position, bounds, type, collidable, speed, dir, damage, health);
	}

}
