package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.Enemy;
import it.unibo.aknightstale.utils.EntityManagerImpl;
import it.unibo.aknightstale.utils.Point2D;
import it.unibo.aknightstale.views.entity.EnemyView;
import it.unibo.aknightstale.views.interfaces.MapView;
import it.unibo.aknightstale.views.map.MapViewImpl;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EnemiesController {

    final private int numEnemies;

    //final private GraphicsContext gc;
    private List<EnemyController> enemiesControllers;

    private MapView mapView;
    public EnemiesController(final int numEnemies/*, final GraphicsContext gc*/, final MapView mapView/*, final Enemy model, final V view, final EntityManager manager*/){
        this.numEnemies = numEnemies;
        enemiesControllers = new LinkedList<>();
        //this.gc = gc;
        this.mapView = mapView;
        //createEnemies((int)gc.getCanvas().getWidth(), (int) gc.getCanvas().getHeight());
        createEnemies(mapView.getScreenWidth(), mapView.getScreenHeight());
    }

    public List<EnemyController> getEnemiesControllers() {
        return enemiesControllers;
    }

    private void createEnemies(final double screenWidth, final double screenHeight){
        //create enemies
        Random random = new Random();
        for(int i = 0; i < this.numEnemies; i++){
            /*Utilizzare EntityfactoryImpl*/
            Enemy enemy = new Enemy(new Point2D(random.nextInt((int)screenWidth), random.nextInt((int)screenHeight)));
            EnemyView enemyView = new EnemyView();
            enemiesControllers.add(new EnemyController(enemy, enemyView, new EntityManagerImpl()));
        }
    }

    public void drawEnemies(){
        this.enemiesControllers.forEach( (c) -> {
            switch (c.getModel().getDirection()) {
                case LEFT:
                    c.getModel().goLeft();
                    break;
                case RIGHT:
                    c.getModel().goRight();
                    break;
                case UP:
                    c.getModel().goUp();
                    break;
                case DOWN:
                    c.getModel().goDown();
                    break;
            }
            c.getView().update(c.getModel().getDirection());

            mapView.drawTile(c.getView(), c.getModel().getPosition().getX(), c.getModel().getPosition().getY());
            //gc.drawImage(c.getView().getImage(), c.getModel().getPosition().getX(), c.getModel().getPosition().getY());
        });
    }

    public void update(/*final Point2D playerPosition*/){
        this.enemiesControllers.forEach( c -> {
            if(c.getModel().getHealth() == 0){
                enemiesControllers.remove(c);
            }
        });
    }

    public void updateDirection(final Point2D playerPosition){
        this.enemiesControllers.forEach( c -> {
            c.getModel().update(playerPosition);

            c.move(c.getModel().getDirection());

        });
    }

    public void adaptPositionToScreenSize(final double traslX, final double traslY) {
        this.enemiesControllers.forEach(c -> {
            double newX = c.getModel().getPosition().getX() * traslX;
            double newY = c.getModel().getPosition().getY() * traslY;
            c.getModel().setPosition(new Point2D(newX, newY));
        });
    }

    public int getNumEnemy() {
        return this.enemiesControllers.size();
    }
}
