package it.unibo.aknightstale;

import it.unibo.aknightstale.controllers.entity.CharacterController;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.factories.EntityFactory;
import it.unibo.aknightstale.models.entity.factories.EntityFactoryImpl;
import it.unibo.aknightstale.models.entity.input.InputPlayer;
import it.unibo.aknightstale.models.entity.input.InputPlayerImpl;
import it.unibo.aknightstale.utils.CollisionManagerImpl;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public final class JavaFXApp extends Application {

    static final double PREF_WIDTH = 600.0;
    static final double PREF_HEIGHT = 600.0;
    static final double BHO = 37.6;

    private double widthWindow;
    private double heightWindow;

    private final EntityFactory factory = new EntityFactoryImpl();

    @Override
    public void start(final Stage stage) throws IOException {
        stage.setTitle("A Knight's Tale");
        this.setWidthWindow(PREF_WIDTH);
        this.setHeightWindow(PREF_HEIGHT);

        final Pane root = new Pane();
        root.setPrefSize(widthWindow, heightWindow);

        final Scene gameScene = new Scene(root);
        stage.setScene(gameScene);

        final Canvas canvas = new Canvas(widthWindow, heightWindow);
        root.getChildren().add(canvas);

        final GraphicsContext context = canvas.getGraphicsContext2D();

        final CharacterController<? extends Character, ? extends AnimatedEntityView> player = factory.getPlayer();

        final var collision = new CollisionManagerImpl(factory.getEntityManager().getEntities(), widthWindow,
                heightWindow);
        factory.getEntityManager().setCollisionManager(collision);

        final InputPlayer input = new InputPlayerImpl(player, gameScene);

        stage.widthProperty().addListener((obs, oldval, newval) -> {
            canvas.setWidth(newval.doubleValue());
            this.setWidthWindow(newval.doubleValue());
            collision.setWidthScreen(newval.doubleValue());
        });

        stage.heightProperty().addListener((obs, oldval, newval) -> {
            canvas.setHeight(newval.doubleValue());
            this.setHeightWindow(newval.doubleValue());
            collision.setHeightScreen(newval.doubleValue() - BHO);      //modificare BHO
        });

        final var gameloop = new AnimationTimer() {

            @Override
            public void handle(final long now) {
                context.save();
                context.clearRect(0, 0, widthWindow, heightWindow);
                input.update();
                var playerModel = player.getModel();
                var playerPosition = playerModel.getPosition();
                context.drawImage(player.getView().getImage(), playerPosition.getX(),
                        playerPosition.getY());
                player.getView().drawHealthBar(
                        context,
                        playerPosition.getX(),
                        playerPosition.getY() - 10,
                        playerModel.getHealth(),
                        playerModel.getMaxHealth()
                );
                context.restore();
            }
        };
        gameloop.start();
        stage.show();
    }

    private void setWidthWindow(final double widthWindow) {
        this.widthWindow = widthWindow;
    }

    private void setHeightWindow(final double heightWindow) {
        this.heightWindow = heightWindow;
    }

}
