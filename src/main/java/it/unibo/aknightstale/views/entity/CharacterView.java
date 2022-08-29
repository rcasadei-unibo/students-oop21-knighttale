package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static javafx.scene.paint.Color.LIGHTGREEN;

public abstract class CharacterView extends EntityViewImpl implements AnimatedEntityView {
    /**
     * The max width of the health bar.
     */
    protected static final int HEALTH_BAR_MAX_WIDTH = 50;

    protected static final String SEPARATOR = System.getProperty("file.separator");
    protected static final String URL = "it" + SEPARATOR + "unibo" + SEPARATOR + "aknightstale" + SEPARATOR + "entity"
            + SEPARATOR + "player" + SEPARATOR;
    private static final int WIDTH_IMAGE = 50;
    private static final int HEIGHT_IMAGE = 50;

    private static final int MAX_NUM_FRAME = 50;

    protected String idle_right;
    protected String idle_left;
    protected String idle_up;
    protected String idle_down;

    protected String walk_right;
    protected String walk_left;
    protected String walk_up;
    protected String walk_down;

    private Status status;

    private int frameNum;

    public CharacterView(final Image image, final Status s) {
        super(image);
        this.status = s;
    }

    /**
     * Get the entity status.
     * 
     * @return The entity status.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStatus(final Status s) {
        this.status = s;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawHealthBar(final GraphicsContext gc, final double x, final double y, final double health,
            final double maxHealth) {
        gc.setFill(LIGHTGREEN);
        gc.fillRect(x, y, health / maxHealth * HEALTH_BAR_MAX_WIDTH, 2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Direction dir) {
        if (this.getStatus() == Status.WALK) {
            switch (dir) {
            case RIGHT:
                setImage(new Image(idle_right, WIDTH_IMAGE, HEIGHT_IMAGE, true, false),
                        new Image(walk_right, WIDTH_IMAGE, HEIGHT_IMAGE, true, false));
                break;
            case LEFT:
                setImage(new Image(idle_left, WIDTH_IMAGE, HEIGHT_IMAGE, true, false),
                        new Image(walk_left, WIDTH_IMAGE, HEIGHT_IMAGE, true, false));
                break;
            case DOWN:
                setImage(new Image(idle_down, WIDTH_IMAGE, HEIGHT_IMAGE, true, false),
                        new Image(walk_down, WIDTH_IMAGE, HEIGHT_IMAGE, true, false));
                break;
            case UP:
                setImage(new Image(idle_up, WIDTH_IMAGE, HEIGHT_IMAGE, true, false),
                        new Image(walk_up, WIDTH_IMAGE, HEIGHT_IMAGE, true, false));
                break;
            default:
            }
            this.frameNum++;
            if (!checkSpriteNum(MAX_NUM_FRAME * 2)) {
                this.frameNum = 0;
            }
        } else {
            super.setImage(new Image(URL + "player_" + this.getStatus() + "_" + dir + ".png", WIDTH_IMAGE, HEIGHT_IMAGE,
                    true, false));
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
