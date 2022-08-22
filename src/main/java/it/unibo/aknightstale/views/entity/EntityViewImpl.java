package it.unibo.aknightstale.views.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.scene.image.Image;

public class EntityViewImpl implements EntityView {

    /**
     * The image of entity.
     */
    private Image image;

    public EntityViewImpl(final Image image) {
        super();
        this.setImage(image);
    }

    /**
     * Set the new image of entity.
     * 
     * @param image
     */
    @SuppressFBWarnings("EI_EXPOSE_REP2")       //impossible clone the image
    public void setImage(final Image image) {
        this.image = image;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressFBWarnings("EI_EXPOSE_REP")       //impossible clone the image
    @Override
    public Image getImage() {
        return this.image;
    }

}
