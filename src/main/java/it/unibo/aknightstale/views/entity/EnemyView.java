package it.unibo.aknightstale.views.entity;

public class EnemyView extends CharacterView {

    private static final double WIDTH = 20;
    private static final double HEIGHT = 24;


    public EnemyView() {
        super(Status.WALK, "enemy" + SEPARATOR + "enemy_idle_right.png", WIDTH, HEIGHT, "enemy" + SEPARATOR + "enemy");

        idleRight = "enemy" + SEPARATOR + "enemy_idle_right.png";
        idleLeft = "enemy" + SEPARATOR + "enemy_idle_left.png";
        idleUp = "enemy" + SEPARATOR + "enemy_idle_up.png";
        idleDown = "enemy" + SEPARATOR + "enemy_idle_down.png";
        walkRight = "enemy" + SEPARATOR + "enemy_walk_right.png";
        walkLeft = "enemy" + SEPARATOR + "enemy_walk_left.png";
        walkUp = "enemy" + SEPARATOR + "enemy_walk_up.png";
        walkDown = "enemy" + SEPARATOR + "enemy_walk_down.png";
    }
}
