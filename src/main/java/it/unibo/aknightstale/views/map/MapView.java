package it.unibo.aknightstale.views.map;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class MapView {

    List<Tile> tiles = new ArrayList<>();
    final private GraphicsContext gc;

    public MapView(final GraphicsContext gc){
        // adding tiles
        tiles.add(new Tile("/tiles/grass01.png", 0));  //passo l'url perchè altrimenti dato che uso un inputStream per leggere l'indirizzo, chiamando getUrl tornerà null
        tiles.add(new Tile("/tiles/tree.png", 1));
        tiles.add(new Tile("/tiles/wall.png", 2));
        tiles.add(new Tile("/tiles/water03.png", 3));
        tiles.add(new Tile("/tiles/water04.png", 4));
        tiles.add(new Tile("/tiles/water05.png", 5));
        tiles.add(new Tile("/tiles/water06.png", 6));
        tiles.add(new Tile("/tiles/water07.png", 7));
        tiles.add(new Tile("/tiles/water08.png", 8));
        tiles.add(new Tile("/tiles/water09.png", 9));
        tiles.add(new Tile("/tiles/water10.png", 10));
        tiles.add(new Tile("/tiles/water11.png", 11));
        this.gc = gc;
    }

    public Tile getFloor(){ return this.tiles.get(0); }

    public Tile getTree(){ return this.tiles.get(1); }

    public List<Tile> getTiles() { return tiles; }

    public void clearMap(){
        this.gc.clearRect(0, 0, this.gc.getCanvas().getWidth(), this.gc.getCanvas().getHeight());
    }

    public void drawTile(final Tile tile,final double x, final double y){
        gc.drawImage(tile.getImage(), x, y);
    }
    public void resize(double tileWidth, double tileHeight) {
        this.tiles.forEach(t -> {
            t.setHeight(tileHeight);
            t.setWidth(tileWidth);
        });
    }

}
