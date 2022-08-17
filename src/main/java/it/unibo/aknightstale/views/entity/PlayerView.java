package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;
import javafx.scene.image.Image;

public class PlayerView extends CharacterView {

    static final String SEPARATOR = System.getProperty("file.separator");
    static final String URL = "it" + SEPARATOR + "unibo" + SEPARATOR + "aknightstale"
                                + SEPARATOR + "entity" + SEPARATOR + "player" + SEPARATOR;

    static final Image PLAYER_IDLE_RIGHT = new Image(URL + "player_idle_right.png");
    static final Image PLAYER_IDLE_LEFT = new Image(URL + "player_idle_left.png");
    static final Image PLAYER_IDLE_UP = new Image(URL + "player_idle_up.png");
    static final Image PLAYER_IDLE_DOWN = new Image(URL + "player_idle_down.png");

    static final Image PLAYER_WALK_RIGHT = new Image(URL + "player_walk_right.png");
    static final Image PLAYER_WALK_LEFT = new Image(URL + "player_walk_left.png");
    static final Image PLAYER_WALK_UP = new Image(URL + "player_walk_up.png");
    static final Image PLAYER_WALK_DOWN = new Image(URL + "player_walk_down.png");

    static final int MAX_NUM_FRAME = 50;

    private int frameNum;

    public PlayerView() {
        super(PLAYER_IDLE_RIGHT, Status.IDLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Direction dir) {
        if (this.getStatus() == Status.WALK) {
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
            default:
            }
            this.frameNum++;
            if (!checkSpriteNum(MAX_NUM_FRAME * 2)) {
                this.frameNum = 0;
            }
        } else {
            super.setImage(new Image(URL + "player_" + this.getStatus() + "_" + dir + ".png"));
        }
    }

    private void setImage(final Image a, final Image b) {
        if (checkSpriteNum(MAX_NUM_FRAME)) {
            super.setImage(a);
        } else {
            super.setImage(b);
        }
    }

    private boolean checkSpriteNum(final int n) {
        return this.frameNum < n;
    }

}
