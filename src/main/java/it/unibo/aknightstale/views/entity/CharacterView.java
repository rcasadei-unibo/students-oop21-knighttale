package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static javafx.scene.paint.Color.LIGHTGREEN;

public abstract class CharacterView extends EntityViewImpl implements AnimatedEntityView {
    /**
     * The max width of the health bar.
     */
    protected static final int HEALTH_BAR_MAX_WIDTH = 25;

    protected static final String SEPARATOR = System.getProperty("file.separator");

    private final String nameEntity;
    private final double widthImage;
    private final double heightImage;


    private static final int MAX_NUM_FRAME = 12;

    protected String idleRight;
    protected String idleLeft;
    protected String idleUp;
    protected String idleDown;

    protected String walkRight;
    protected String walkLeft;
    protected String walkUp;
    protected String walkDown;

    private Status status;

    private int frameNum;

    public CharacterView(final Status s, final String nameImage, final double width, final double height, final String nameEntity) {
        super(nameImage, width, height);
        this.nameEntity = nameEntity;
        this.status = s;
        this.widthImage = width;
        this.heightImage = height;
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
        if (health < maxHealth) {
            gc.setFill(LIGHTGREEN);
            gc.fillRect(x, y, (health / maxHealth) * HEALTH_BAR_MAX_WIDTH, 5);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Direction dir) {
        if (this.getStatus() == Status.WALK) {
            switch (dir) {
            case RIGHT:
                setImage(new Image(getClass().getResourceAsStream(idleRight), widthImage, heightImage, true, false),
                        new Image(getClass().getResourceAsStream(walkRight), widthImage, heightImage, true, false));
                break;
            case LEFT:
                setImage(new Image(getClass().getResourceAsStream(idleLeft), widthImage, heightImage, true, false),
                        new Image(getClass().getResourceAsStream(walkLeft), widthImage, heightImage, true, false));
                break;
            case DOWN:
                setImage(new Image(getClass().getResourceAsStream(idleDown), widthImage, heightImage, true, false),
                        new Image(getClass().getResourceAsStream(walkDown), widthImage, heightImage, true, false));
                break;
            case UP:
                setImage(new Image(getClass().getResourceAsStream(idleUp), widthImage, heightImage, true, false),
                        new Image(getClass().getResourceAsStream(walkUp), widthImage, heightImage, true, false));
                break;
            default:
            }
            this.frameNum++;
            if (!checkSpriteNum(MAX_NUM_FRAME * 2)) {
                this.frameNum = 0;
            }
        } else {
            super.setImage(new Image(getClass().getResourceAsStream(nameEntity + "_" + this.getStatus() + "_" + dir + ".png"), widthImage, heightImage,
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
