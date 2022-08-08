package it.unibo.aknightstale.models.entity.factories;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.controllers.entity.PlayerController;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.models.entity.Player;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.utils.EntityManagerImpl;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.PlayerView;
import javafx.geometry.Point2D;

public class EntityFactoryImpl implements EntityFactory {
	
	private final static Point2D spawn_player = new Point2D(100, 100);
	private final static double damage = 50.0;
	private final static double health = 100.0;
	private final static double speed = 1.0;
	
	private final EntityManager manager;

	public EntityFactoryImpl() {
		super();
		this.manager = new EntityManagerImpl();
	}

	@Override
	public EntityManager getEntityManager() {
		return this.manager;
	}

	@Override
	public CharacterController<? extends CharacterModel, ? extends AnimatedEntityView> getPlayer() {
		var player = new PlayerController<CharacterModel, AnimatedEntityView>(
					new Player(spawn_player, damage, health, speed),
					new PlayerView(),
					getEntityManager());
		this.manager.addEntity(player);
		return player;
	}

}
