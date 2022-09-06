package it.unibo.aknightstale.controllers.interfaces;

import it.unibo.aknightstale.controllers.entity.ObstacleController;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.models.entity.ObstacleEntity;
import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.views.interfaces.MapView;
import it.unibo.aknightstale.views.map.SolidTile;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public interface MapController extends Controller<MapView> {

    static final int NUM_COL = 48;
    static final int NUM_ROW = 27;

    void drawMap();

    void updateScreenSize();

    void drawEnemies();

    void repositionEntities();

    void drawPlayer();

    void update();
}
