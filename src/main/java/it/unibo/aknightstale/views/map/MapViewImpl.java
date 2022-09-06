package it.unibo.aknightstale.views.map;

import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.views.BaseView;
import it.unibo.aknightstale.views.entity.EntityView;
import it.unibo.aknightstale.controllers.interfaces.MapController;
import it.unibo.aknightstale.views.interfaces.MapView;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MapViewImpl extends BaseView<MapController> implements MapView  {

    @FXML
    Canvas canvas;
    @FXML
    AnchorPane pane;

    private GraphicsContext gc;

    List<Tile> tiles = new ArrayList<>();

    public MapViewImpl(){
        super("Game");
        // adding tiles
        tiles.add(new CrossableTile("grass01.png", 0, EntityType.TILE));  //passo l'url perchè altrimenti dato che uso un inputStream per leggere l'indirizzo, chiamando getUrl tornerà null
        tiles.add(new SolidTile("tree.png", 1, EntityType.OBSTACLE));
        tiles.add(new SolidTile("wall.png", 2, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water03.png", 3, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water04.png", 4, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water05.png", 5, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water06.png", 6, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water07.png", 7, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water08.png", 8, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water09.png", 9, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water10.png", 10, EntityType.OBSTACLE));
        tiles.add(new SolidTile("water11.png", 11, EntityType.OBSTACLE));
    }

    public void init() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        this.gc = this.canvas.getGraphicsContext2D();

        canvas.widthProperty().addListener(evt -> {getController().repositionEntities(); getController().updateScreenSize();getController().drawMap();});
        canvas.heightProperty().addListener(evt -> {getController().repositionEntities(); getController().updateScreenSize();getController().drawMap();});

        final var gameloop = new AnimationTimer() {

            @Override
            public void handle(final long now) {
                getController().drawMap();
                getController().update();
                getController().drawEnemies();
                getController().drawPlayer();
                //enemiesController.update();

                //context.drawImage()	//entities
                //gc.restore();

                //controller.clear();
            }
        };
        gameloop.start();

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
