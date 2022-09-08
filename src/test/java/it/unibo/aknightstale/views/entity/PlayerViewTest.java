package it.unibo.aknightstale.views.entity;

import javafx.stage.Stage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.models.entity.factories.EntityFactory;
import it.unibo.aknightstale.models.entity.factories.EntityFactoryImpl;
import it.unibo.aknightstale.utils.CollisionManagerImpl;
import it.unibo.aknightstale.views.BaseViewTest;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.scene.image.Image;
import org.testfx.framework.junit5.Start;

// TODO: Replace with World view
class PlayerViewTest extends BaseViewTest<MainMenuController, MainMenuView> {

    private final EntityFactory factory = new EntityFactoryImpl();
    static final String SEPARATOR = System.getProperty("file.separator");
    static final double WIDTH_WINDOW = 600.0;
    static final double HEIGHT_WINDOW = 600.0;
    static final double WIDTH_PLAYER = 24.0;
    static final double HEIGHT_PLAYER = 32.0;

    PlayerViewTest() {
        super(MainMenuView.class, MainMenuController.class);
    }

    @Start
    @Override
    public void start(final Stage stage) {
        super.start(stage);
    }

    @Test
    @DisplayName("Check player image")
    void checkImage() {
        final var player = this.factory.getPlayer().getView();
        final var path = "it" + SEPARATOR + "unibo" + SEPARATOR + "aknightstale" + SEPARATOR + "views" + SEPARATOR
                + "entity" + SEPARATOR + "player" + SEPARATOR + "player_idle_right.png";
        Assertions.assertThat(
                 isImageEqual(player.getImage(), new Image(path, WIDTH_PLAYER, HEIGHT_PLAYER, true, false)))
                .isTrue();
    }

    @Test
    @DisplayName("Check player view updated")
    void update() {
        final var player = this.factory.getPlayer();
        this.factory.getEntityManager().setCollisionManager(
                new CollisionManagerImpl(factory.getEntityManager().getEntities(), WIDTH_WINDOW, HEIGHT_WINDOW));
        player.attack();
        player.getView().update(player.getModel().getDirection());
        final var path = "it" + SEPARATOR + "unibo" + SEPARATOR + "aknightstale" + SEPARATOR + "views" + SEPARATOR
                + "entity" + SEPARATOR + "player" + SEPARATOR + "player_attack_right.png";
        Assertions.assertThat(
                 isImageEqual(player.getView().getImage(), new Image(path, WIDTH_PLAYER, HEIGHT_PLAYER, true, false)))
                .isTrue();
    }

    private boolean isImageEqual(final Image firstImage, final Image secondImage) {
        if (firstImage != null && secondImage == null) {
            return false;
        }
        if (firstImage == null) {
            return secondImage == null;
        }

        if (firstImage.getWidth() != secondImage.getWidth()) {
            return false;
        }
        if (firstImage.getHeight() != secondImage.getHeight()) {
            return false;
        }

        // Compare images color
        for (int x = 0; x < firstImage.getWidth(); x++) {
            for (int y = 0; y < firstImage.getHeight(); y++) {
                final int firstArgb = firstImage.getPixelReader().getArgb(x, y);
                final int secondArgb = secondImage.getPixelReader().getArgb(x, y);

                if (firstArgb != secondArgb) {
                    return false;
                }
            }
        }

        return true;
    }

}
