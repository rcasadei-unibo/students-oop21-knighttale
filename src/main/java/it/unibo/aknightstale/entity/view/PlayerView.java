package it.unibo.aknightstale.entity.view;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.Status;
import javafx.scene.image.Image;

public class PlayerView extends CharacterView {

	final static Image PLAYER_IDLE_RIGHT = new Image("player/player_idle_right.png");
    final static Image PLAYER_IDLE_LEFT = new Image("player/player_idle_left.png");
    final static Image PLAYER_IDLE_UP = new Image("player/player_idle_up.png");
    final static Image PLAYER_IDLE_DOWN = new Image("player/player_idle_down.png");
    
    final static Image PLAYER_WALK_RIGHT = new Image("player/player_walk_right.png");
    final static Image PLAYER_WALK_LEFT = new Image("player/player_walk_left.png");
    final static Image PLAYER_WALK_UP = new Image("player/player_walk_up.png");
    final static Image PLAYER_WALK_DOWN = new Image("player/player_walk_down.png");
   
    final static int MAX_NUM_FRAME = 50;

    private int frameNum = 0;
    
    public PlayerView() {
    	super(PLAYER_IDLE_RIGHT, Status.IDLE);
    }
    
    @Override
	public void update(Direction dir) {
		if (this.status == Status.WALK) {
			switch (dir) {
	        case RIGHT:
	            setImage(PLAYER_IDLE_RIGHT, PLAYER_WALK_RIGHT);
	            break;
	        case LEFT:
	            setImage(PLAYER_IDLE_LEFT, PLAYER_WALK_LEFT);
	            break;
	        case DOWN:
	            setImage(PLAYER_IDLE_DOWN, PLAYER_WALK_DOWN);
	            break;
	        case UP:
	            setImage(PLAYER_IDLE_UP, PLAYER_WALK_UP);
	            break;
			}
			this.frameNum++;
			if(!checkSpriteNum(MAX_NUM_FRAME * 2)) {
	            this.frameNum = 0; 
	        }
		} else {
			super.image = new Image("layouts/player_" + this.status + "_" + dir + ".png");
		}
	}

	private void setImage(Image a, Image b) {
		if (checkSpriteNum(MAX_NUM_FRAME)) {
            super.image = a;
        } else {
            super.image = b;
        }
	}

	private boolean checkSpriteNum(int n) {
        return this.frameNum < n; 
	}

}
