package it.unibo.aknightstale.views.entity;

import javafx.scene.image.Image;

public class PlayerView extends CharacterView {

    public PlayerView() {
        super(new Image(URL + "player_idle_right.png"), Status.IDLE);
        
        idle_right = URL + "player_idle_right.png";
        idle_left = URL + "player_idle_left.png";
        idle_up = URL + "player_idle_up.png";
        idle_down = URL + "player_idle_down.png";
        walk_right = URL + "player_walk_right.png";
        walk_left = URL + "player_walk_left.png";
        walk_up = URL + "player_walk_up.png";
        walk_down = URL + "player_walk_down.png";
    }

}
