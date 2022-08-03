package it.unibo.aknightstale;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import it.unibo.aknightstale.entity.controller.CharacterController;
import it.unibo.aknightstale.entity.controller.PlayerController;
import it.unibo.aknightstale.entity.model.CharacterModel;
import it.unibo.aknightstale.entity.model.Player;
import it.unibo.aknightstale.entity.view.AnimatedEntityView;
import it.unibo.aknightstale.entity.view.PlayerView;
import it.unibo.aknightstale.utility.EntityManagerImpl;

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
        
        player = new PlayerController<CharacterModel, AnimatedEntityView>(
        		new Player(new Point2D(100, 100), 25.0, 100.0, 5.0), 
        		new PlayerView(), new EntityManagerImpl());
        
        var gameloop = new AnimationTimer() {
        	
			@Override
			public void handle(long now) {
				context.save();
				context.clearRect(0, 0, 600, 600);
				//context.drawImage()	//background
				player.moveRight();
				context.drawImage(player.getView().getImage(), player.getModel().getPosition().getX(), player.getModel().getPosition().getY());
				//context.drawImage()	//entities
				context.restore();
			}
		};
		gameloop.start();
		stage.show();
    }
}
