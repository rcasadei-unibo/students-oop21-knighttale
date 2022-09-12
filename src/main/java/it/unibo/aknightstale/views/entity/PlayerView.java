package it.unibo.aknightstale.views.entity;

public class PlayerView extends CharacterView {

    private static final double WIDTH = 24;
    private static final double HEIGHT = 32;
    
    private static final String NAME = "player";

    public PlayerView() {
        super(Status.IDLE, NAME + SEPARATOR + "player_idle_right.png", WIDTH, HEIGHT, NAME + SEPARATOR + NAME);
        
        idleRight = NAME + SEPARATOR + "player_idle_right.png";
        idleLeft = NAME + SEPARATOR + "player_idle_left.png";
        idleUp = NAME + SEPARATOR + "player_idle_up.png";
        idleDown = NAME + SEPARATOR + "player_idle_down.png";
        walkRight = NAME + SEPARATOR + "player_walk_right.png";
        walkLeft = NAME + SEPARATOR + "player_walk_left.png";
        walkUp = NAME + SEPARATOR + "player_walk_up.png";
        walkDown = NAME + SEPARATOR + "player_walk_down.png";
    }

}
