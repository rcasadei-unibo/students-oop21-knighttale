package it.unibo.aknightstale.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.controller.EntityController;
import it.unibo.aknightstale.entity.model.EntityModel;
import it.unibo.aknightstale.entity.view.EntityView;

public class CollisionManagerImpl implements CollisionManager {
	
	private final List<EntityController<? extends EntityModel, ? extends EntityView>> entities;
	private final double widthScreen;
	private final double heightScreen;

	public CollisionManagerImpl(List<EntityController<? extends EntityModel, ? extends EntityView>> entities, double wide, double height) {
		super();
		this.entities = entities;
		this.widthScreen = wide;
		this.heightScreen = height;
	}

	@Override
	public List<EntityController<? extends EntityModel, ? extends EntityView>> checkCollision(EntityController<? extends EntityModel, ? extends EntityView> ec) {
		return this.entities
					.stream()
					.filter(e -> !e.getModel().isCollidable())
					.filter(e -> ec.getModel().getBounds().intersects(e.getModel().getBounds()))
					.collect(Collectors.toList());
	}
	
	@Override
	public List<Direction> canMove(EntityController<? extends EntityModel, ? extends EntityView> ec) {
		var list = new ArrayList<Direction>();
		var e = ec.getModel().getBounds();
		
		if((e.getMinX() + e.getWidth()) < this.widthScreen - 1.0 &&
			this.entities.stream()
			.filter(entity -> entity.getModel().isCollidable())
			.filter(entity -> {
				var bounds = entity.getModel().getBounds();
				return bounds.getMinX() == e.getMinX() + e.getWidth() &&
						((bounds.getMinY() >= e.getMinY() && bounds.getMinY() < e.getMinY() + e.getHeight()) ||
						  (bounds.getMinY() + bounds.getHeight() > e.getMinY() && bounds.getMinY() + bounds.getHeight() <= e.getMinY()));
			})
			.collect(Collectors.toList()).isEmpty()) {
			list.add(Direction.RIGHT);
		}
		if(e.getMinX() > 0 &&
				this.entities.stream()
				.filter(entity -> entity.getModel().isCollidable())
				.filter(entity -> {
					var bounds = entity.getModel().getBounds();
					return bounds.getMinX() + bounds.getWidth() == e.getMinX() &&
							((bounds.getMinY() >= e.getMinY() && bounds.getMinY() < e.getMinY() + e.getHeight()) ||
							  (bounds.getMinY() + bounds.getHeight() > e.getMinY() && bounds.getMinY() + bounds.getHeight() <= e.getMinY()));
				})
				.collect(Collectors.toList()).isEmpty()) {
			list.add(Direction.LEFT);
		}
		if((e.getMinY() + e.getHeight()) < this.heightScreen - 1.0 &&
				this.entities.stream()
				.filter(entity -> entity.getModel().isCollidable())
				.filter(entity -> {
					var bounds = entity.getModel().getBounds();
					return bounds.getMinY() == e.getMinY() + e.getHeight() &&
							((bounds.getMinX() >= e.getMinX() && bounds.getMinX() < e.getMinX() + e.getWidth()) ||
							  (bounds.getMinX() + bounds.getWidth() > e.getMinX() && bounds.getMinX() + bounds.getWidth() <= e.getMinX()));
				})
				.collect(Collectors.toList()).isEmpty()) {
			list.add(Direction.DOWN);
		}
		if(e.getMinY() > 0 &&
				this.entities.stream()
				.filter(entity -> entity.getModel().isCollidable())
				.filter(entity -> {
					var bounds = entity.getModel().getBounds();
					return bounds.getMinY() + bounds.getHeight() == e.getMinY() &&
							((bounds.getMinX() >= e.getMinX() && bounds.getMinX() < e.getMinX() + e.getWidth()) ||
							  (bounds.getMinX() + bounds.getWidth() > e.getMinX() && bounds.getMinX() + bounds.getWidth() <= e.getMinX()));
				})
				.collect(Collectors.toList()).isEmpty()) {
			list.add(Direction.UP);
		}
		return list;
	}

}
