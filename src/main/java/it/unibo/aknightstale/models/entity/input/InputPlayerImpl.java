package it.unibo.aknightstale.models.entity.input;

import java.util.ArrayList;
import java.util.List;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import javafx.scene.Scene;

public class InputPlayerImpl implements InputPlayer {

	private final CharacterController<? extends CharacterModel, ? extends AnimatedEntityView> player;
	private final List<String> keyPressed;

	public InputPlayerImpl(final CharacterController<? extends CharacterModel, ? extends AnimatedEntityView> player, final Scene scene) {
		super();
		this.player = player;
		this.keyPressed = new ArrayList<>();

		scene.setOnKeyPressed(event -> {
			final var keyName = event.getCode().toString();
			if (!keyPressed.contains(keyName)) {
				keyPressed.add(keyName);
			}
		}); 

		scene.setOnKeyReleased(event -> {
			final var keyName = event.getCode().toString();
			if (keyPressed.contains(keyName)) {
				keyPressed.remove(keyName);
			}
		}); 
	}

	@Override
	public void update() {
	    if (keyPressed.contains("A")) {
	        this.player.moveLeft();
	    }
	    if (keyPressed.contains("D")) {
	        this.player.moveRight();
		}
		if (keyPressed.contains("W")) {
			this.player.moveUp(); 
		}
		if (keyPressed.contains("S")) { 
			this.player.moveDown(); 
		}
		if (keyPressed.contains("SPACE")) {
			this.player.attack(); 
		}
	}

}
