package it.unibo.aknightstale.controllers;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.controllers.interfaces.ScoreboardController;
import it.unibo.aknightstale.controllers.utils.ControllerFactory;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import it.unibo.aknightstale.views.interfaces.ScoreboardView;

public class MainMenuControllerImpl extends BaseController<MainMenuView> implements MainMenuController {
    /**
     * Show scoreboard view.
     */
    public void showScoreboard() {
        var scoreboardController = ControllerFactory.createController(ScoreboardController.class, ScoreboardView.class);
        scoreboardController.showView();
    }
}
