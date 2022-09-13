package it.unibo.aknightstale.views.entity;

public class PlayerView extends CharacterView {

    private static final double WIDTH = 24;
    private static final double HEIGHT = 32;

    private static final String NAME = "player";

    public PlayerView() {
        super(Status.IDLE, NAME + SEPARATOR + "player_idle_right.png", WIDTH, HEIGHT, NAME + SEPARATOR + NAME);

        setIdleRight(NAME + SEPARATOR + "player_idle_right.png");
        setIdleLeft(NAME + SEPARATOR + "player_idle_left.png");
        setIdleUp(NAME + SEPARATOR + "player_idle_up.png");
        setIdleDown(NAME + SEPARATOR + "player_idle_down.png");
        setWalkRight(NAME + SEPARATOR + "player_walk_right.png");
        setWalkLeft(NAME + SEPARATOR + "player_walk_left.png");
        setWalkUp(NAME + SEPARATOR + "player_walk_up.png");
        setWalkDown(NAME + SEPARATOR + "player_walk_down.png");
    }

}
