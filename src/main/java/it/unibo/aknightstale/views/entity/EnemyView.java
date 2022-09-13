package it.unibo.aknightstale.views.entity;

public class EnemyView extends CharacterView {

    private static final double WIDTH = 20;
    private static final double HEIGHT = 24;
    private static final String NAME = "enemy";

    public EnemyView() {
        super(Status.WALK, NAME + SEPARATOR + "enemy_idle_right.png", WIDTH, HEIGHT, NAME + SEPARATOR + NAME);

        setIdleRight(NAME + SEPARATOR + "enemy_idle_right.png");
        setIdleLeft(NAME + SEPARATOR + "enemy_idle_left.png");
        setIdleUp(NAME + SEPARATOR + "enemy_idle_up.png");
        setIdleDown(NAME + SEPARATOR + "enemy_idle_down.png");
        setWalkRight(NAME + SEPARATOR + "enemy_walk_right.png");
        setWalkLeft(NAME + SEPARATOR + "enemy_walk_left.png");
        setWalkUp(NAME + SEPARATOR + "enemy_walk_up.png");
        setWalkDown(NAME + SEPARATOR + "enemy_walk_down.png");
    }
}
