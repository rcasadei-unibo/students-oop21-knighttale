package it.unibo.aknightstale.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.models.entity.factories.EntityFactory;
import it.unibo.aknightstale.models.entity.factories.EntityFactoryImpl;
import it.unibo.aknightstale.views.BaseViewTest;
import it.unibo.aknightstale.views.interfaces.MainMenuView;

class EntityManagerTest extends BaseViewTest<MainMenuController, MainMenuView> {

    private final EntityFactory factory = new EntityFactoryImpl();

    @Test
    @DisplayName("Create entity")
    void create() {
        final var player = this.factory.getPlayer();
        final var manager = this.factory.getEntityManager();
        Assertions.assertThat(manager.getEntities().stream().count()).isEqualTo(1);
        manager.removeEntity(player);
        Assertions.assertThat(manager.getEntities().stream().count()).isEqualTo(0);
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
