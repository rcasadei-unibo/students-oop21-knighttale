package it.unibo.aknightstale.views;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.fxml.FXML;

public class MainMenuViewImpl extends BaseView<MainMenuController> implements MainMenuView {
    /**
     * Action when exit button is clicked. Closes the window when clicked.
     */
    @FXML
    protected final void onExitButtonClicked() {
        this.getController().closeView();
    }

    /**
     * Action when scoreboard button is clicked. Shows the scoreboard view.
     */
    @FXML
    protected final void onScoreboardButtonClicked() {
        this.getController().showScoreboard();
    }

    /**
     * Gets the window title.
     *
     * @return the window title.
     */
    @Override
    public String getWindowTitle() {
        return "Main menu";
    }
}
