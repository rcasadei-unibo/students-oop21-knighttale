package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;
import javafx.scene.image.Image;

public class EnemyView extends CharacterView {

    final static private double width = 24;
    final static private double height = 32;

    static final String SEPARATOR = System.getProperty("file.separator");
    static final String URL = "it" + SEPARATOR + "unibo" + SEPARATOR + "aknightstale"
            + SEPARATOR + "entity" + SEPARATOR + "player" + SEPARATOR;

    final static Image PLAYER_IDLE_RIGHT = new Image(EnemyView.class.getResourceAsStream(URL + "player_idle_right.png"), width, height, false, false);
    final static Image PLAYER_IDLE_LEFT = new Image(EnemyView.class.getResourceAsStream(URL + "player_idle_left.png"), width, height, false, false);
    final static Image PLAYER_IDLE_UP = new Image(EnemyView.class.getResourceAsStream(URL + "player_idle_up.png"), width, height, false, false);
    final static Image PLAYER_IDLE_DOWN = new Image(EnemyView.class.getResourceAsStream(URL + "player_idle_down.png"), width, height, false, false);
    final static Image PLAYER_WALK_RIGHT = new Image(EnemyView.class.getResourceAsStream(URL + "player_walk_right.png"), width, height, false, false);
    final static Image PLAYER_WALK_LEFT = new Image(EnemyView.class.getResourceAsStream(URL + "player_walk_left.png"), width, height, false, false);
    final static Image PLAYER_WALK_UP = new Image(EnemyView.class.getResourceAsStream(URL + "player_walk_up.png"), width, height, false, false);
    final static Image PLAYER_WALK_DOWN = new Image(EnemyView.class.getResourceAsStream(URL + "player_walk_down.png"), width, height, false, false);

    final static int MAX_NUM_FRAME = 15;

    private int frameNum = 0;

    public EnemyView() {
        super(PLAYER_IDLE_RIGHT, Status.WALK);
    }

    @Override
    public void update(Direction dir) {
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
            }
            this.frameNum++;
            if(!checkSpriteNum(MAX_NUM_FRAME * 2)) {
                this.frameNum = 0;
            }
        } else {
            super.setImage(new Image(getClass().getResourceAsStream(URL + "player_" + this.getStatus() + "_" + dir + ".png")));
        }
    }

    private void setImage(Image a, Image b) {
        if (checkSpriteNum(MAX_NUM_FRAME)) {
            super.setImage(a);
        } else {
            super.setImage(b);
        }
    }

    private boolean checkSpriteNum(int n) {
        return this.frameNum < n;
    }


}
