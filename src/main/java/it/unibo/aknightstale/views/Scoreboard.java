package it.unibo.aknightstale.views;

import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import it.unibo.aknightstale.controllers.interfaces.ScoreboardController;
import it.unibo.aknightstale.views.interfaces.ScoreboardView;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import java.util.List;
import java.util.Map;

public class Scoreboard extends BaseView<ScoreboardController> implements ScoreboardView {
    @FXML
    private MFXTableView<Map.Entry<String, Integer>> scoreboardTableView;

    @FXML
    private void initialize() {
        var playerColumn = new MFXTableColumn<Map.Entry<String, Integer>>("Player");
        var scoreColumn = new MFXTableColumn<Map.Entry<String, Integer>>("Score");

        playerColumn.setRowCellFactory(entry -> new MFXTableRowCell<>(Map.Entry::getKey));
        scoreColumn.setRowCellFactory(entry -> new MFXTableRowCell<>(Map.Entry::getValue));

        scoreboardTableView.getTableColumns().addAll(List.of(playerColumn, scoreColumn));
        var filters = scoreboardTableView.getFilters();
        filters.add(new StringFilter<>("Player", Map.Entry::getKey));
        filters.add(new IntegerFilter<>("Score", Map.Entry::getValue));
    }

    @FXML
    public void onMainMenuButtonClicked() {
        getController().returnToMainMenu();
    }

    @Override
    public void show() {
        var list = FXCollections.observableList(List.copyOf(this.getController().getScoreboard()));
        this.scoreboardTableView.setItems(list);
        super.show();
    }

    /**
     * Gets the window title.
     * @return the window title.
     */
    public String getWindowTitle() {
        return "Scoreboard";
    }
}
