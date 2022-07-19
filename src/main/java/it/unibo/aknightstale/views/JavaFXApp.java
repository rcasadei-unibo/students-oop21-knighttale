package it.unibo.aknightstale.views;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

public final class JavaFXApp extends Application {
    @Override
    public void start(final Stage stage) {
        final var mainMenuController = Controller.of(MainMenuController.class, MainMenuView.class)
                .get();
        mainMenuController.showView();
    }
}
