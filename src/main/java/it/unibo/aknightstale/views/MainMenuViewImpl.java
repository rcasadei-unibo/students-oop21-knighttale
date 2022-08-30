package it.unibo.aknightstale.views;

import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.fxml.FXML;

public class MainMenuViewImpl extends BaseView<MainMenuController> implements MainMenuView {
    public MainMenuViewImpl() {
        super("Main Menu");
    }

    /**
     * Action when new game button is clicked. Opens the game map view.
     */
    @FXML
    protected final void onNewGameClicked() {
        this.getController().showMapView();
    }

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
}
