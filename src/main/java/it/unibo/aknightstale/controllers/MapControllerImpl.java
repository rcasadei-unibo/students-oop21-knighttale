package it.unibo.aknightstale.controllers;

import it.unibo.aknightstale.controllers.entity.EnemiesController;
import it.unibo.aknightstale.controllers.entity.ObstacleController;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.interfaces.GameFinishedController;
import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.models.entity.ObstacleEntity;
import it.unibo.aknightstale.models.map.Spawner;
import it.unibo.aknightstale.models.map.SpawnerImpl;
import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.utils.Point2D;
import it.unibo.aknightstale.views.interfaces.GameFinishedView;
import it.unibo.aknightstale.controllers.interfaces.MapController;
import it.unibo.aknightstale.views.interfaces.MapView;
import it.unibo.aknightstale.views.map.SolidTile;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MapControllerImpl extends BaseController<MapView> implements MapController {


    Map<Pair<Integer, Integer>, Integer> mapTileNum = new HashMap<>();
    List<ObstacleController> obstacleControllers = new LinkedList<>();

    private double screenWidth;
    private double screenHeight;

    private EnemiesController enemiesController;


    private int killedEnemies = 0;
    private int totalEnemies = 20;


    @Override
    public void showView() {
        this.enemiesController = new EnemiesController(totalEnemies, getView());
        getView().init();

        updateScreenSize();
        // converting map
        readTextMap();
        //adding trees
        Spawner treeSpawner = new SpawnerImpl(getView().getTree(), 30, this.mapTileNum);
        this.mapTileNum = treeSpawner.getMap();
        super.showView();
        this.drawMap();
    }

    public void openGameFinishedScreen(){
        var controllerView =  Controller.of(GameFinishedController.class, GameFinishedView.class).get();
        controllerView.setScore(killedEnemies);
        controllerView.showView();
    }

    public static int getNumCol() {
        return NUM_COL;
    }

    public static int getNumRow() {
        return NUM_ROW;
    }

    public void drawMap() {

        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;

        getView().clearMap();
        int num;
        while (col < NUM_COL && row < NUM_ROW) {
            num = mapTileNum.get(new Pair<Integer, Integer>(row, col));
            //num = 0;
            //gc.drawImage(mapView.getTiles().get(num).getImage(), x, y);
            getView().drawTile(getView().getTiles().get(num), x, y);
            col++;
            x += this.getView().getTiles().get(num).getWidth();
            if (col == NUM_COL) {
                x = 0;
                y += this.getView().getTiles().get(num).getHeight();;
                col = 0;
                row++;
            }
        }
    }

    private void readTextMap() {
        InputStream is = getView().getClass().getResourceAsStream("map.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;
        try {
            while (col < NUM_COL && row < NUM_ROW) {

                String line = br.readLine();

                while (col < NUM_COL) {
                    List<String> numLine = Arrays.asList(line.split(" "));
                    int num = Integer.parseInt(numLine.get(col));
                    mapTileNum.put(new Pair<>(row, col), num);
                    // If I have to draw a tile that represent an obstacle, then I'll create an obstacle entity
                    if(getView().getTiles().get(num).getEntityType() == EntityType.OBSTACLE){
                        // create obstacle entity and adds it to list
                        double x = col * getView().getTiles().get(num).getWidth();
                        double y = col * getView().getTiles().get(num).getHeight();

                        this.obstacleControllers.add(new ObstacleController(new ObstacleEntity(new BordersImpl(x, y, getView().getTiles().get(num).getWidth(), getView().getTiles().get(num).getHeight())/*,new Point2D(x,y)*/), (SolidTile) getView().getTiles().get(num)));
                    }
                    col++;
                }

                if (col == NUM_COL) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void updateScreenSize(){
        this.screenWidth = getView().getScreenWidth();
        this.screenHeight = getView().getScreenHeight();

        final double tileWidth = Math.ceil (this.screenWidth/NUM_COL);
        final double tileHeight = Math.ceil (this.screenHeight/NUM_ROW);

        getView().resize(tileWidth, tileHeight);
    }

    public void repositionEntities() {
        double traslX = getView().getScreenWidth() / this.screenWidth;
        double traslY = getView().getScreenHeight() / this.screenHeight;
        enemiesController.adaptPositionToScreenSize(traslX, traslY);
    }

    @Override
    public void drawPlayer() {
        /*EntityFactoryImpl.getPlayer*/
    }

    @Override
    public void update() {
        enemiesController.update(/*player.getposition()*/);
        this.killedEnemies = totalEnemies - enemiesController.getNumEnemy();
        if(killedEnemies == totalEnemies /*|| this.player.getHealt == 0*/){
            this.openGameFinishedScreen();
        }
    }

    @Override
    public void drawEnemies() {
        enemiesController.drawEnemies();
    }

}
