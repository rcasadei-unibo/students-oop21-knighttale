package it.unibo.aknightstale.views.entity;

import javafx.scene.image.Image;

public class EntityViewImpl implements EntityView {

    /**
     * The image of entity.
     */
    private Image image;

    public EntityViewImpl(final Image image) {
        super();
        this.image = image;
    }

    /**
     * Set the new image of entity.
     * 
     * @param image
     */
    public void setImage(final Image image) {
        this.image = image;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImage() {
        return this.image;
    }

}
