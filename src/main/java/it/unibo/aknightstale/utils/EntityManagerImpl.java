package it.unibo.aknightstale.utils;

import java.util.ArrayList;
import java.util.List;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public class EntityManagerImpl implements EntityManager {
	
	private List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> entities;
	private CollisionManager collision;

	public EntityManagerImpl() {
		super();
		this.entities = new ArrayList<>();
	}
	
	public EntityManagerImpl(List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> l) {
		super();
		this.entities = l;
	}

	@Override
	public List<List<EntityController<? super CharacterModel, ? super AnimatedEntityView>>> update() {
		return this.collision.update();
	}

	@Override
	public void addEntity(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec) {
		if (!this.entities.contains(ec)) {
			this.entities.add(ec);
		}
	}

	@Override
	public void removeEntity(EntityController<? super CharacterModel, ? super AnimatedEntityView> ec) {
		this.entities.stream().filter(e -> e.equals(ec)).forEach(e -> this.entities.remove(e));
	}

	@Override
	public List<EntityController<? super CharacterModel, ? super AnimatedEntityView>> getEntities() {
		return this.entities;
	}

	@Override
	public CollisionManager getCollisionManager() {
		return this.collision;
	}

	@Override
	public void setCollisionManager(CollisionManager collision) {
		this.collision = collision;		
	}

}
