package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;
import javafx.scene.image.Image;

public abstract class CharacterView extends EntityViewImpl implements AnimatedEntityView {

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

    @Override
    public abstract void update(Direction d);

}
