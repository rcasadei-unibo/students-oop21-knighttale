package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.Enemy;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.factories.EntityFactory;
import it.unibo.aknightstale.utils.Point2D;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.interfaces.MapView;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EnemiesController {

    private final int numEnemies;
    private final EntityFactory factory;

    private final List<CharacterController<Character, AnimatedEntityView>> enemiesControllers;

    private final MapView mapView;
    public EnemiesController(final int numEnemies, final MapView mapView, final EntityFactory factory) {
        this.numEnemies = numEnemies;
        enemiesControllers = new LinkedList<>();
        this.factory = factory;
        this.mapView = mapView;
        //createEnemies((int)gc.getCanvas().getWidth(), (int) gc.getCanvas().getHeight());
        createEnemies(mapView.getScreenWidth(), mapView.getScreenHeight());
    }

    /*public List<CharacterController<Character, AnimatedEntityView>> getEnemiesControllers() {
        return enemiesControllers;
    }*/

    private void createEnemies(final double screenWidth, final double screenHeight) {
        //create enemies
        Random random = new Random();
        for (int i = 0; i < this.numEnemies; i++) {
            /*Utilizzare EntityfactoryImpl*/
            /*Enemy enemy = new Enemy(new Point2D(random.nextInt((int)screenWidth), random.nextInt((int)screenHeight)));
            EnemyView enemyView = new EnemyView();
            enemiesControllers.add(new EnemyController(enemy, enemyView, new EntityManagerImpl()));*/
            enemiesControllers.add(this.factory.getEnemy(random.nextDouble() * screenWidth, random.nextDouble() * screenHeight));
        }
    }

    public void drawEnemies() {
        this.enemiesControllers.forEach((c) -> {
            switch (c.getModel().getDirection()) {
                case LEFT:
                    c.moveLeft();
                    break;
                case RIGHT:
                    c.moveRight();
                    break;
                case UP:
                    c.moveUp();
                    break;
                case DOWN:
                    c.moveDown();
                    break;
            }
            //c.getView().update(c.getModel().getDirection());

            mapView.drawTile(c.getView(), c.getModel().getPosition().getX(), c.getModel().getPosition().getY());
            //gc.drawImage(c.getView().getImage(), c.getModel().getPosition().getX(), c.getModel().getPosition().getY());
        });
    }

    public void update(/*final Point2D playerPosition*/) {
        this.enemiesControllers.forEach(c -> {
            if (c.getModel().getHealth() == 0) {
                enemiesControllers.remove(c);
            }
        });
    }

    public void updateDirection(final Point2D playerPosition) {
        this.enemiesControllers.forEach(c -> {
            ((Enemy) c.getModel()).update(playerPosition);

            //(EnemyController<Enemy>)c.move(c.getModel().getDirection());

        });
    }

    public void adaptPositionToScreenSize(final double traslX, final double traslY) {
        this.enemiesControllers.forEach(c -> {
            /*double newX = c.getModel().getPosition().getX() * traslX;
            double newY = c.getModel().getPosition().getY() * traslY;
            c.getModel().setPosition(new Point2D(newX, newY));*/
            c.adaptPositionToScreenSize(traslX, traslY);
        });
    }

    public int getNumEnemy() {
        return this.enemiesControllers.size();
    }
}
