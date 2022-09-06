package it.unibo.aknightstale.views.interfaces;

import it.unibo.aknightstale.controllers.interfaces.MapController;
import it.unibo.aknightstale.views.entity.EntityView;
import it.unibo.aknightstale.views.map.Tile;

import java.util.List;

public interface MapView extends View<MapController> {

    double getScreenWidth();
     double getScreenHeight();
     Tile getFloor();
     Tile getTree();
     List<Tile> getTiles();
     void clearMap();
     void drawTile(final EntityView tile, final double x, final double y);
    void resize(double tileWidth, double tileHeight);

    void init();


}
