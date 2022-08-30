package it.unibo.aknightstale.views.map;

import it.unibo.aknightstale.controllers.MapControllerImpl;
import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.views.BaseView;
import it.unibo.aknightstale.views.entity.EntityView;
import it.unibo.aknightstale.views.interfaces.MapView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MapViewImpl extends BaseView implements Initializable, MapView  {

    @FXML
    Canvas canvas;
    @FXML
    AnchorPane pane;


    private MapControllerImpl mapController;

    private GraphicsContext gc;

    List<Tile> tiles = new ArrayList<>();

    public MapViewImpl(){
        // adding tiles
        tiles.add(new CrossableTile("/tiles/grass01.png", 0, EntityType.TILE));  //passo l'url perchè altrimenti dato che uso un inputStream per leggere l'indirizzo, chiamando getUrl tornerà null
        tiles.add(new SolidTile("/tiles/tree.png", 1, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/wall.png", 2, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water03.png", 3, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water04.png", 4, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water05.png", 5, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water06.png", 6, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water07.png", 7, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water08.png", 8, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water09.png", 9, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water10.png", 10, EntityType.OBSTACLE));
        tiles.add(new SolidTile("/tiles/water11.png", 11, EntityType.OBSTACLE));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        this.gc = this.canvas.getGraphicsContext2D();
    }


    public void setMapController(MapControllerImpl mapController) {
        this.mapController = mapController;
        canvas.widthProperty().addListener(evt -> {mapController.updateScreenSize();mapController.drawMap();});
        canvas.heightProperty().addListener(evt -> {mapController.updateScreenSize();mapController.drawMap();});
    }

    public Tile getFloor(){ return this.tiles.get(0); }

    public Tile getTree(){ return this.tiles.get(1); }

    public List<Tile> getTiles() { return tiles; }


    public double getScreenWidth() { return canvas.getWidth(); }

    public double getScreenHeight() { return canvas.getHeight(); }

    public void clearMap(){
        this.gc.clearRect(0, 0, this.gc.getCanvas().getWidth(), this.gc.getCanvas().getHeight());
    }

    public void drawTile(final EntityView tile, final double x, final double y){
        gc.drawImage(tile.getImage(), x, y);
    }
    public void resize(double tileWidth, double tileHeight) {
        this.tiles.forEach(t -> {
            t.setHeight(tileHeight);
            t.setWidth(tileWidth);
        });
    }

    public GraphicsContext getGraphic(){
        return this.canvas.getGraphicsContext2D();
    }


}
