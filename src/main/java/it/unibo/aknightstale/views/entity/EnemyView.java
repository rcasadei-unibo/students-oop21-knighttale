package it.unibo.aknightstale.views.entity;

public class EnemyView extends CharacterView {

    private static final double WIDTH = 20;
    private static final double HEIGHT = 24;


    public EnemyView() {
        super(Status.WALK, "enemy" + SEPARATOR + "enemy_idle_right.png", WIDTH, HEIGHT, "enemy" + SEPARATOR + "enemy");

        idle_right = "enemy" + SEPARATOR + "enemy_idle_right.png";
        idle_left = "enemy" + SEPARATOR + "enemy_idle_left.png";
        idle_up = "enemy" + SEPARATOR + "enemy_idle_up.png";
        idle_down = "enemy" + SEPARATOR + "enemy_idle_down.png";
        walk_right = "enemy" + SEPARATOR + "enemy_walk_right.png";
        walk_left = "enemy" + SEPARATOR + "enemy_walk_left.png";
        walk_up = "enemy" + SEPARATOR + "enemy_walk_up.png";
        walk_down = "enemy" + SEPARATOR + "enemy_walk_down.png";
    }
}
