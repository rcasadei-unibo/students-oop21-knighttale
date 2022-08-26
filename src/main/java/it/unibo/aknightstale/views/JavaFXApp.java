package it.unibo.aknightstale.views;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

public final class JavaFXApp extends Application {
    @Override
    public void start(final Stage stage) {
        final var controllerFactory = Controller.of(MainMenuController.class, MainMenuView.class);
        controllerFactory.getViewFactory().stage(stage);
        final var mainMenuController = controllerFactory.get();
        mainMenuController.showView();
    }
}
