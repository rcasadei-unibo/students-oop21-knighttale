package it.unibo.aknightstale.views.entity;

public class PlayerView extends CharacterView {

    private static final double WIDTH = 24;
    private static final double HEIGHT = 32;

    public PlayerView() {
        super(Status.IDLE, "player" + SEPARATOR + "player_idle_right.png", WIDTH, HEIGHT, "player" + SEPARATOR + "player");
        
        idle_right = "player" + SEPARATOR + "player_idle_right.png";
        idle_left = "player" + SEPARATOR + "player_idle_left.png";
        idle_up = "player" + SEPARATOR + "player_idle_up.png";
        idle_down = "player" + SEPARATOR + "player_idle_down.png";
        walk_right = "player" + SEPARATOR + "player_walk_right.png";
        walk_left = "player" + SEPARATOR + "player_walk_left.png";
        walk_up = "player" + SEPARATOR + "player_walk_up.png";
        walk_down = "player" + SEPARATOR + "player_walk_down.png";
    }

}
