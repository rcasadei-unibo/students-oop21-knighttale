package it.unibo.aknightstale.views;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.controllers.utils.ControllerFactory;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

public final class JavaFXApp extends Application {
    /** Main window of the application. */
    public static final Window MAIN_WINDOW = new Window("MAIN");

    @Override
    public void start(final Stage stage) {
        final var mainMenuController = ControllerFactory.createController(MainMenuController.class, MainMenuView.class);
        mainMenuController.showView();
    }
}
