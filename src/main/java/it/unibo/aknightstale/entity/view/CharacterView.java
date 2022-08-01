package it.unibo.aknightstale.entity.view;

import it.unibo.aknightstale.entity.Direction;
import it.unibo.aknightstale.entity.Status;
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
