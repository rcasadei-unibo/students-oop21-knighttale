package it.unibo.aknightstale.models;

import com.esotericsoftware.jsonbeans.Json;
import it.unibo.aknightstale.App;
import it.unibo.aknightstale.views.AlertType;
import it.unibo.aknightstale.views.factories.Alert;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Scoreboard {
    private static final String SCOREBOARD_FILE_NAME = "scoreboard.json";
    private final Json json = new Json();
    private Scores scores = new Scores();

    /**
     * Get scoreboard values.
     */
    public Set<Map.Entry<String, Integer>> getEntries() {
        return this.scores.entrySet();
    }

    /**
     * Get scoreboard score of a player.
     */
    public Integer getScore(final String name) {
        return this.scores.get(name);
    }

    /**
     * Set scoreboard score for a player.
     */
    public void setScore(final String name, final Integer score) {
        this.scores.put(name, score);
    }

    /**
     * Load scoreboard from file.
     */
    public void load() {
        final var path = App.getFilePath(SCOREBOARD_FILE_NAME);
        if (!Files.exists(path)) {
            try {
                final var directory = path.getParent();
                if (directory != null) {
                    Files.createDirectories(directory);
                }
                Files.createFile(path);
            } catch (IOException e) {
                Alert.showAlert(AlertType.ERROR, "Error creating scoreboard file: " + e.getMessage());
                e.printStackTrace();
            }
        }
        try (var file = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
            final var scoreboard = json.fromJson(this.scores.getClass(), file);
            if (scoreboard != null) {
                this.scores = scoreboard;
            }
        } catch (IOException e) {
            Alert.showAlert(AlertType.ERROR, "Error loading scoreboard file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Save scoreboard to file.
     */
    public void save() {
        try (FileWriter file = new FileWriter(App.getFilePath(SCOREBOARD_FILE_NAME).toFile(), StandardCharsets.UTF_8)) {
            json.toJson(this.scores, file);
        } catch (IOException e) {
            Alert.showAlert(AlertType.ERROR, "Error saving scoreboard file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class Scores extends HashMap<String, Integer> {
        private static final long serialVersionUID = 1L;
    }
}
