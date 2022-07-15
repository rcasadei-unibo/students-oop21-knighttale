package it.unibo.aknightstale.views;

import io.github.palexdev.materialfx.controls.MFXButton;
import it.unibo.aknightstale.controllers.interfaces.MainMenuController;
import it.unibo.aknightstale.views.interfaces.MainMenuView;
import javafx.fxml.FXML;

public class MainMenuViewImpl extends BaseView<MainMenuController> implements MainMenuView {
    @FXML
    private MFXButton exitButton;

    @FXML
    protected final void onExitButtonClicked() {
        this.getController().closeView();
    }

    @FXML
    protected final void onScoreboardButtonClicked() {
        this.getController().showScoreboard();
    }

    /**
     * Gets the window title.
     * @return the window title.
     */
    @Override
    public String getWindowTitle() {
        return "Main menu";
    }
}
