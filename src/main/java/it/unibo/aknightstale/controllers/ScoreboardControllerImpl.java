package it.unibo.aknightstale.controllers;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.controllers.interfaces.ScoreboardController;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import it.unibo.aknightstale.views.interfaces.ScoreboardView;

import java.util.Map;
import java.util.Set;

public class ScoreboardControllerImpl extends BaseController<ScoreboardView> implements ScoreboardController {
    private final it.unibo.aknightstale.models.Scoreboard scoreboard = new it.unibo.aknightstale.models.Scoreboard(); //NOPMD - suppressed AvoidFieldNameMatchingTypeName - To remove when renaming MVC

    /**
     * Get scoreboard values.
     */
    @Override
    public Set<Map.Entry<String, Integer>> getScoreboard() {
        return this.scoreboard.getEntries();
    }

    /**
     * Return to main menu.
     */
    @Override
    public void returnToMainMenu() {
        Controller.of(MainMenuController.class, MainMenuView.class).get().showView();
    }

    /**
     * {@inheritDoc}
     * Also updates the view scoreboard.
     */
    @Override
    public void showView() {
        this.scoreboard.load();
        getView().updateScoreboard(this.getScoreboard());
        super.showView();
    }
}
