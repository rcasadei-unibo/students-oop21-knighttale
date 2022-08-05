package it.unibo.aknightstale.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.entity.Direction;
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
					.filter(e -> ec.getModel().getBounds().intersects(e.getModel().getBounds()))
					.collect(Collectors.toList());
	}

	@Override
	public List<Direction> canMove(EntityController<? extends EntityModel, ? extends EntityView> ec) {
		var list = new ArrayList<Direction>();
		var e = ec.getModel().getBounds();
		
		if((e.getMinX() + e.getWidth()) < this.widthScreen - 1.0) {
			list.add(Direction.RIGHT);
		}
		if(e.getMinX() > 0) {
			list.add(Direction.LEFT);
		}
		if((e.getMinY() + e.getHeight()) < this.heightScreen - 1.0) {
			list.add(Direction.DOWN);
		}
		if(e.getMinY() > 0) {
			list.add(Direction.UP);
		}
		return list;
	}

}
