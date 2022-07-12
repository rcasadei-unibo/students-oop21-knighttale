package it.unibo.aknightstale.views.utils;

import it.unibo.aknightstale.views.interfaces.MainMenuView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ViewFactoryTest {

    @Test
    @DisplayName("Test loadView()")
    void loadView() {
        var view = ViewFactory.loadView(MainMenuView.class);
        assertInstanceOf(MainMenuView.class, view);
    }
}
