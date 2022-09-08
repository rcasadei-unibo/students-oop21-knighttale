package it.unibo.aknightstale.controllers.interfaces;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.interfaces.MapView;

public interface MapController extends Controller<MapView> {

    static final int NUM_COL = 48;
    static final int NUM_ROW = 27;

    void drawMap();

    void updateScreenSize();

    void drawEnemies();

    void repositionEntities();

    void drawPlayer();

    void update();

    CharacterController<? extends Character, ? extends AnimatedEntityView> getPlayer();
    
    void handleInput();

    void idlePlayer();

    void updatePlayer(Direction left);

    void playerAttack();

    void moveEnemies();
}

