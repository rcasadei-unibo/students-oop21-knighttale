package it.unibo.aknightstale.utility;

import java.util.ArrayList;
import java.util.List;

import it.unibo.aknightstale.entity.controller.EntityController;
import it.unibo.aknightstale.entity.model.Character;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;

public class EntityManagerImpl implements EntityManager {
	
	private List<EntityController<? super Character, ? super AnimatedEntityView>> entities;
	private final CollisionManager collision;

	public EntityManagerImpl() {
		super();
		this.entities = new ArrayList<>();
		this.collision = null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addEntity(EntityController<? super Character, ? super AnimatedEntityView> ec) {
		if (!this.entities.contains(ec)) {
			this.entities.add(ec);
		}
	}

	@Override
	public void removeEntity(EntityController<? super Character, ? super AnimatedEntityView> ec) {
		this.entities.stream().filter(e -> e.equals(ec)).forEach(e -> this.entities.remove(e));
	}

	@Override
	public List<EntityController<? super Character, ? super AnimatedEntityView>> getEntities() {
		return this.entities;
	}

	@Override
	public CollisionManager getCollisionManager() {
		return this.collision;
	}

}
