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

    private Status status;

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
    public void drawHealthBar(final GraphicsContext gc, final double x, final double y, final double health, final double maxHealth) {
        gc.setFill(LIGHTGREEN);
        gc.fillRect(x, y, health / maxHealth * HEALTH_BAR_MAX_WIDTH, 2);
    }

    @Override
    public abstract void update(Direction d);

}
