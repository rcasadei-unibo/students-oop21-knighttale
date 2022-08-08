package it.unibo.aknightstale.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public class CollisionManagerImpl implements CollisionManager {
	
	private final List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> entities;
	private final double widthScreen;
	private final double heightScreen;

	public CollisionManagerImpl(List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> entities, double wide, double height) {
		super();
		this.entities = entities;
		this.widthScreen = wide;
		this.heightScreen = height;
	}

	@Override
	public List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> checkCollision(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec) {
		return this.entities
					.stream()
					.filter(e -> e.getModel().isCollidable())
					.filter(e -> ec.getModel().getBounds().intersects(e.getModel().getBounds()))
					.collect(Collectors.toList());
	}
	
	@Override
	public List<Direction> canMove(EntityController<? extends CharacterModel, ? extends AnimatedEntityView> ec) {
		var list = new ArrayList<Direction>();
		var e = ec.getModel().getBounds();
		
		if((e.getMinX() + e.getWidth()) < this.widthScreen - 1.0 &&
			this.entities.stream()
			.filter(entity -> !entity.getModel().isCollidable())
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
				.filter(entity -> !entity.getModel().isCollidable())
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
				.filter(entity -> !entity.getModel().isCollidable())
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
				.filter(entity -> !entity.getModel().isCollidable())
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

	@Override
	public List<List<EntityController<? super CharacterModel, ? super AnimatedEntityView>>> update() {
		List<List<EntityController<? super CharacterModel, ? super AnimatedEntityView>>> list = new ArrayList<>();
		this.entities
		.stream()
		.filter(e -> e.getModel().isCollidable())
		.forEach(e -> {
			List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> l = new ArrayList<>();
			for (var en : this.entities) {
				if(!e.equals(en) && en.getModel().isCollidable() && 
					e.getModel().getBounds().intersects(en.getModel().getBounds())) {
					l.add(en);
					if(!l.contains(e)) {
						l.add(e);
					}
				}
			}
			if(!l.isEmpty()) {
				list.add(l);
			}
		});
		return list;
	}

}
