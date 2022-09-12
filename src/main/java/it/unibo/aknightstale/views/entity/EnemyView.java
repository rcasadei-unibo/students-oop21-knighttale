package it.unibo.aknightstale.views.entity;

public class EnemyView extends CharacterView {

    private static final double WIDTH = 20;
    private static final double HEIGHT = 24;
    private static final String NAME = "enemy";

    public EnemyView() {
        super(Status.WALK, "enemy" + SEPARATOR + "enemy_idle_right.png", WIDTH, HEIGHT, "enemy" + SEPARATOR + "enemy");

        idleRight = NAME + SEPARATOR + "enemy_idle_right.png";
        idleLeft = NAME + SEPARATOR + "enemy_idle_left.png";
        idleUp = NAME + SEPARATOR + "enemy_idle_up.png";
        idleDown = NAME + SEPARATOR + "enemy_idle_down.png";
        walkRight = NAME + SEPARATOR + "enemy_walk_right.png";
        walkLeft = NAME + SEPARATOR + "enemy_walk_left.png";
        walkUp = NAME + SEPARATOR + "enemy_walk_up.png";
        walkDown = NAME + SEPARATOR + "enemy_walk_down.png";
    }
}
