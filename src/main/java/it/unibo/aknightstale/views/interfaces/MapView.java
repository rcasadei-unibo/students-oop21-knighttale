package it.unibo.aknightstale.views.interfaces;

import it.unibo.aknightstale.controllers.interfaces.MapController;
import it.unibo.aknightstale.views.entity.EntityView;
import it.unibo.aknightstale.views.map.Tile;

import java.util.List;

public interface MapView extends View<MapController> {

    /**
     * @return the current width of the game window*/
    double getScreenWidth();

    /**
     * @return the current width of the game window*/
    double getScreenHeight();

    /**
     * @return the tile that represent the floor of the game world.
     * */
    Tile getFloor();

    /**
     * @return the tile that represent the tree of the game world.
     * */
    Tile getTree();

    /**
     * @return a list that contains all the tiles used in the map*/
     List<Tile> getTiles();

     /**
      * Delete all the tiles and entities present in the game world.*/
     void clearMap();

     /**
      * draw tiles or entities in the game world.*/
     void draw(final EntityView tile, final double x, final double y);

    /**
     * Resize the size of all tiles of the game world.
     * @param tileWidth the new tile's width
     * @param tilHeight the new tile's height*/
    void resizeTiles(double tileWidth, double tileHeight);

    /**
     * Initialize the game world.*/
    void init();

    /**
     * Stop the game when it's finished.*/
    void stopGame();
}
