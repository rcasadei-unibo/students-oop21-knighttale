package it.unibo.aknightstale.models.map;

import it.unibo.aknightstale.controllers.MapControllerImpl;
import it.unibo.aknightstale.views.map.Tile;
import javafx.util.Pair;

import java.util.Map;
import java.util.Random;

public class SpawnerImpl implements Spawner {


    private final Tile tile;
    private final int num;
    private final Map<Pair<Integer, Integer>, Integer> tileMap;

    public SpawnerImpl(final Tile tile, final int num, final Map<Pair<Integer, Integer>, Integer> tileMap) {
        this.tile = tile;
        this.num = num;
        this.tileMap = tileMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Pair<Integer, Integer>, Integer> getMap() {
        final Random random = new Random();
        int i = 0;
        while (i < this.num) {
            final int row = random.nextInt(MapControllerImpl.getNumRow());
            final int col = random.nextInt(MapControllerImpl.getNumCol());

            // don't spawn tiles near map's limit or collidable entity like wall
            if (this.tileMap.get(new Pair<>(row, col)) == 0 && this.tileMap.get(new Pair<>(row - 1, col)) == 0
                    && this.tileMap.get(new Pair<>(row + 1, col)) == 0
                    && this.tileMap.get(new Pair<>(row, col - 1)) == 0
                    && this.tileMap.get(new Pair<>(row, col + 1)) == 0) {
                this.tileMap.put(new Pair<>(row, col), this.tile.getIndex());
                i++;
            }
        }
        return this.tileMap;
    }

}
