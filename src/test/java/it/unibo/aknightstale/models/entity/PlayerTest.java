package it.unibo.aknightstale.models.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.models.entity.factories.EntityFactory;
import it.unibo.aknightstale.models.entity.factories.EntityFactoryImpl;
import it.unibo.aknightstale.views.BaseViewTest;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.geometry.Point2D;

class PlayerTest extends BaseViewTest<MainMenuController, MainMenuView> {

    private final EntityFactory factory = new EntityFactoryImpl();

    @Test
    @DisplayName("Check type")
    void checkType() {
        final var player = this.factory.getPlayer().getModel();
        Assertions.assertThat(player.getType()).isEqualTo(EntityType.PLAYER);
    }

    @Test
    @DisplayName("Move player")
    void checkMovement() {
        final var player = this.factory.getPlayer().getModel();
        var position = player.getPosition();
        player.goRight();
        position = new Point2D(position.getX() + player.getSpeed(), position.getY());
        Assertions.assertThat(position).isEqualTo(player.getPosition());
    }

    @Test
    @DisplayName("Player attacks entity")
    void attack() {
        final var player = this.factory.getPlayer().getModel();
        final LifeEntity entity = new Player(player.getPosition()); // cambiare con nemico
        for (int i = 0; i < 4; i++) {
            player.attack(entity);
        }
        Assertions.assertThat(entity.isDead()).isTrue();
    }

    @Test
    @DisplayName("Check life of entity")
    void checklife() {
        final var player = this.factory.getPlayer().getModel();
        final LifeEntity entity = new Player(player.getPosition()); // cambiare con nemico
        final var life = entity.getHealth();
        player.attack(entity);
        Assertions.assertThat(entity.getHealth()).isEqualTo(life - player.getDamage());
    }

    @Override
    public Class<MainMenuView> getViewInterface() {
        return MainMenuView.class;
    }

    @Override
    public Class<MainMenuController> getControllerInterface() {
        return MainMenuController.class;
    }

}