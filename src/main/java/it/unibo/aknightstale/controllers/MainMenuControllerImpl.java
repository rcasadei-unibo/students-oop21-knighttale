package it.unibo.aknightstale.controllers;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.controllers.interfaces.ScoreboardController;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import it.unibo.aknightstale.views.interfaces.ScoreboardView;

public class MainMenuControllerImpl extends BaseController<MainMenuView> implements MainMenuController {
    /**
     * Show scoreboard view.
     */
    @Override
    public void showScoreboard() {
        final var scoreboardController = Controller.of(ScoreboardController.class, ScoreboardView.class).get();
        scoreboardController.showView();
    }
}
