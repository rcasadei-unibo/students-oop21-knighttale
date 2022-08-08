package it.unibo.aknightstale;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.controllers.entity.PlayerController;
import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.models.entity.Player;
import it.unibo.aknightstale.models.entity.input.InputPlayer;
import it.unibo.aknightstale.models.entity.input.InputPlayerImpl;
import it.unibo.aknightstale.utils.CollisionManagerImpl;
import it.unibo.aknightstale.utils.EntityManagerImpl;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.PlayerView;

public final class JavaFXApp extends Application {
	
	private final static double WIDTH_WINDOW = 600.0;
	private final static double HEIGHT_WINDOW = 600.0;
	
	private CharacterController<CharacterModel, AnimatedEntityView> player;	//final

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
        
        var manager = new EntityManagerImpl();
        
        player = new PlayerController<CharacterModel, AnimatedEntityView>(
        		new Player(new Point2D(100, 100), 25.0, 100.0, 5.0), 
        		new PlayerView(), manager);
        
        manager.addEntity(player);
        var collision = new CollisionManagerImpl(manager.getEntities(), WIDTH_WINDOW, HEIGHT_WINDOW);
        manager.setCollisionManager(collision);
        InputPlayer input = new InputPlayerImpl(player, gameScene);
        
        var gameloop = new AnimationTimer() {
        	
			@Override
			public void handle(long now) {
				context.save();
				context.clearRect(0, 0, 600, 600);
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
