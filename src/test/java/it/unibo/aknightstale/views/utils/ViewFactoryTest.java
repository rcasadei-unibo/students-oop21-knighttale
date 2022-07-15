package it.unibo.aknightstale.views.utils;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.views.BaseViewTest;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.stage.Stage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Test class for {@link ViewFactory}.
 */
@ExtendWith(ApplicationExtension.class)
class ViewFactoryTest extends BaseViewTest<MainMenuController, MainMenuView> {
    @Start
    @Override
    public void start(final Stage stage) {
        super.start(stage);
    }

    @Override
    public Class<MainMenuView> getViewInterface() {
        return MainMenuView.class;
    }

    @Override
    public Class<MainMenuController> getControllerInterface() {
        return MainMenuController.class;
    }

    /**
     * Test executed with MainMenuView.
     */
    @Test
    @DisplayName("Test loadView()")
    void loadView() {
        final var view = ViewFactory.loadView(MainMenuView.class);
        Assertions.assertThat(view).isInstanceOf(MainMenuView.class);
    }
}
