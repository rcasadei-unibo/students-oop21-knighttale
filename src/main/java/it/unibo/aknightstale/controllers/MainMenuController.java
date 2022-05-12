package it.unibo.aknightstale.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class MainMenuController {
    @FXML
    private MFXButton exitButton;

    @FXML
    protected final void onExitButtonClicked() {
        System.exit(0);
    }
}
