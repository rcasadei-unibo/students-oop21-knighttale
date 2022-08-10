package it.unibo.aknightstale;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.models.entity.factories.EntityFactory;
import it.unibo.aknightstale.models.entity.factories.EntityFactoryImpl;
import it.unibo.aknightstale.models.entity.input.InputPlayer;
import it.unibo.aknightstale.models.entity.input.InputPlayerImpl;
import it.unibo.aknightstale.utils.CollisionManagerImpl;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public final class JavaFXApp extends Application {

	final static double WIDTH_WINDOW = 600.0;
	final static double HEIGHT_WINDOW = 600.0;

	private final EntityFactory factory = new EntityFactoryImpl();	//final

    @Override
    public void start(final Stage stage) throws IOException {
        stage.setTitle("A Knight's Tale");

        final Pane root = new Pane();
        root.setPrefSize(WIDTH_WINDOW, HEIGHT_WINDOW);

        final Scene gameScene = new Scene(root);
        stage.setScene(gameScene);

        final Canvas canvas = new Canvas(WIDTH_WINDOW, HEIGHT_WINDOW);
        root.getChildren().add(canvas);

        final GraphicsContext context = canvas.getGraphicsContext2D();

        final CharacterController<? extends CharacterModel, ? extends AnimatedEntityView> player = factory.getPlayer();    
        final var collision = new CollisionManagerImpl(factory.getEntityManager().getEntities(), WIDTH_WINDOW, HEIGHT_WINDOW);
        factory.getEntityManager().setCollisionManager(collision);
        final InputPlayer input = new InputPlayerImpl(player, gameScene);

        final var gameloop = new AnimationTimer() {

			@Override
			public void handle(final long now) {
				context.save();
				context.clearRect(0, 0, WIDTH_WINDOW, HEIGHT_WINDOW);
				//context.drawImage()	//background
				input.update();
				context.drawImage(player.getView().getImage(), player.getModel().getPosition().getX(), player.getModel().getPosition().getY());
				//context.drawImage()	//entities
				context.restore();
			}
		};
		gameloop.start();
		stage.show();
    }
}
