package it.unibo.aknightstale.views.entity;

import it.unibo.aknightstale.models.entity.Direction;
import javafx.scene.image.Image;

public abstract class CharacterView extends EntityViewImpl implements AnimatedEntityView {
	
	protected Status status;

	public CharacterView(Image image, Status s) {
		super(image);
		this.status = s;
	}

	@Override
	public void setStatus(Status s) {
		this.status = s;
	}

	@Override
	public abstract void update(Direction d);

}
