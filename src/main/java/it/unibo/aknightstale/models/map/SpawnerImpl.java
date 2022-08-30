package it.unibo.aknightstale.models.map;

import it.unibo.aknightstale.controllers.MapController;
import it.unibo.aknightstale.views.map.AbstractTile;
import javafx.util.Pair;

import java.util.Map;
import java.util.Random;

public class SpawnerImpl implements Spawner{


    final private AbstractTile tile;
    final private int num;
    Map<Pair<Integer, Integer>, Integer> tileMap;

    public SpawnerImpl(final AbstractTile tile, final int num, final Map<Pair<Integer, Integer>, Integer> tileMap){
        this.tile = tile;
        this.num = num;
        this.tileMap = tileMap;
    }

    public Map<Pair<Integer, Integer>, Integer> getMap(){
        Random random = new Random();
        int i = 0;
        while(i < this.num){
            int row = random.nextInt(MapController.getNumRow());
            int col = random.nextInt(MapController.getNumCol());

            // don't spawn tiles near map's limit or collidable entity like wall
            if(this.tileMap.get(new Pair(row, col)) == 0 && this.tileMap.get(new Pair(row-1, col)) == 0
                    && this.tileMap.get(new Pair(row+1, col)) == 0
                    && this.tileMap.get(new Pair(row, col-1)) == 0
                    && this.tileMap.get(new Pair(row, col+1)) == 0) {
                this.tileMap.put(new Pair(row, col), this.tile.getIndex());
                i++;
            }
        }
        return this.tileMap;
    }

}
