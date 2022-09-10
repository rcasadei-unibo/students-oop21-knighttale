package it.unibo.aknightstale.controllers;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.controllers.entity.EnemiesControllerImpl;
import it.unibo.aknightstale.controllers.entity.ObstacleController;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.interfaces.GameFinishedController;
import it.unibo.aknightstale.controllers.interfaces.MapController;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.models.entity.ObstacleEntity;
import it.unibo.aknightstale.models.entity.factories.EntityFactory;
import it.unibo.aknightstale.models.entity.factories.EntityFactoryImpl;
import it.unibo.aknightstale.models.map.Spawner;
import it.unibo.aknightstale.models.map.SpawnerImpl;
import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.utils.CollisionManagerImpl;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.Status;
import it.unibo.aknightstale.views.interfaces.GameFinishedView;
import it.unibo.aknightstale.views.interfaces.MapView;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/**
 * The type Map controller.
 */
public class MapControllerImpl extends BaseController<MapView> implements MapController {


    private Map<Pair<Integer, Integer>, Integer> mapTileNum = new HashMap<>();
    private final List<ObstacleController> obstacleControllers = new LinkedList<>();

    private double screenWidth;
    private double screenHeight;

    private EnemiesControllerImpl enemiesController;


    private int killedEnemies = 0;
    private final int totalEnemies = 20;
    private final EntityFactory factory = new EntityFactoryImpl();

    private CharacterController<? extends Character, ? extends AnimatedEntityView> player;
    private CollisionManagerImpl collision;

    @Override
    public void showView() {
        player = factory.getPlayer();
        this.enemiesController = new EnemiesControllerImpl(totalEnemies, getView(), factory);
        this.collision = new CollisionManagerImpl(factory.getEntityManager().getEntities(), this.screenWidth,
                this.screenHeight);
        factory.getEntityManager().setCollisionManager(collision);

        updateScreenSize();

        // converting map
        readTextMap();

        //adding trees to map
        Spawner treeSpawner = new SpawnerImpl(getView().getTree(), 30, this.mapTileNum);
        this.mapTileNum = treeSpawner.getMap();

        //binding tiles to entities
        this.bindToEntities();

        super.showView();
        getView().init();
        this.drawMap();
    }

    private void bindToEntities() {
        this.mapTileNum.forEach((position, num) -> {
            // If I have to draw a tile that represent an obstacle, then I'll create an obstacle entity
            if (getView().getTiles().get(num).getEntityType() == EntityType.OBSTACLE) {
                // create obstacle entity and adds it to list
                double x = position.getValue() * getView().getTiles().get(num).getWidth();
                double y = position.getKey() * getView().getTiles().get(num).getHeight();
                double width = getView().getTiles().get(num).getWidth();
                double height = getView().getTiles().get(num).getHeight();
                var borders = new BordersImpl(x, y, width, height);
                var obstacleModel = new ObstacleEntity(borders);
                var obstacleView = getView().getTiles().get(num);
                var obstacle = new ObstacleController<Character, AnimatedEntityView>(obstacleModel, obstacleView);
                this.obstacleControllers.add(obstacle);
                this.factory.getEntityManager().addEntity(obstacle);
            }
        });
    }

    public EnemiesControllerImpl getEnemiesController() {
        return enemiesController;
    }

    @Override
    public CharacterController<? extends Character, ? extends AnimatedEntityView> getPlayer() {
        return player;
    }

    @Override
    public void setIdlePlayer() {
        this.player.getView().setStatus(Status.IDLE);
        this.player.getView().update(this.player.getModel().getDirection());
    }

    private void openGameFinishedScreen() {
        var controllerView =  Controller.of(GameFinishedController.class, GameFinishedView.class).get();
        controllerView.setScore(killedEnemies);
        controllerView.showView();
    }

    /**
     * Gets num col of the map.
     *
     * @return the num col
     */
    public static int getNumCol() {
        return NUM_COL;
    }

    /**
     * Gets num row of the map.
     *
     * @return the num row
     */
    public static int getNumRow() {
        return NUM_ROW;
    }

    public void drawMap() {

        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;

        int num;
        while (col < NUM_COL && row < NUM_ROW) {
            num = mapTileNum.get(new Pair<>(row, col));
            getView().draw(getView().getTiles().get(num), x, y);
            col++;
            x += this.getView().getTiles().get(num).getWidth();
            if (col == NUM_COL) {
                x = 0;
                y += this.getView().getTiles().get(num).getHeight();
                col = 0;
                row++;
            }
        }
    }

    private void readTextMap() {
        InputStream is = getView().getClass().getResourceAsStream("map.txt");
        assert is != null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;
        try {
            while (col < NUM_COL && row < NUM_ROW) {

                String line = br.readLine();

                while (col < NUM_COL) {
                    List<String> numLine = Arrays.asList(line.split(" "));
                    final int num = Integer.parseInt(numLine.get(col));
                    mapTileNum.put(new Pair<>(row, col), num);
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

    @Override
    public void updateScreenSize() {
        this.screenWidth = getView().getScreenWidth();
        this.screenHeight = getView().getScreenHeight();

        collision.setWidthScreen(this.screenWidth);
        collision.setHeightScreen(this.screenHeight);

        final double tileWidth = Math.ceil(this.screenWidth / NUM_COL);
        final double tileHeight = Math.ceil(this.screenHeight / NUM_ROW);

        getView().resizeTiles(tileWidth, tileHeight);
        //this.resizeObstacle();
    }

    public void repositionEntities() {
        double traslX = getView().getScreenWidth() / this.screenWidth;
        double traslY = getView().getScreenHeight() / this.screenHeight;
        enemiesController.adaptPositionToScreenSize(traslX, traslY);
        this.player.adaptPositionToScreenSize(traslX, traslY);
    }

    @Override
    public void drawPlayer() {
        var position = player.getModel().getPosition();
        getView().draw(player.getView(), position.getX(), position.getY());
    }

    @Override
    public void update() {
        enemiesController.removeDeadEnemies();
        this.killedEnemies = totalEnemies - enemiesController.getNumEnemy();
        if (killedEnemies == totalEnemies || this.player.getModel().getHealth() == 0) {
            this.openGameFinishedScreen();
            getView().stopGame();
        }
    }

    @Override
    public void drawEnemies() {
        enemiesController.drawEnemies();
    }

    @Override
    public void updatePlayer(final Direction direction) {
        switch (direction) {
            case UP:
                this.player.moveUp();
                break;
            case DOWN:
                this.player.moveDown();
                break;
            case LEFT:
                this.player.moveLeft();
                break;
            case RIGHT:
                this.player.moveRight();
                break;
            default:
                break;
        }
    }

    @Override
    public void playerAttack() {
        this.player.attack();
    }

    @Override
    public void moveEnemies() {
        this.enemiesController.updateDirection(player.getModel().getPosition());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacterController<Character, AnimatedEntityView>> getEnemies() {
        return this.enemiesController.getEnemiesControllers();
    }


}
