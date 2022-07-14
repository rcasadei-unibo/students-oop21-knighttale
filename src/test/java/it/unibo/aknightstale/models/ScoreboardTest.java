package it.unibo.aknightstale.models;

import it.unibo.aknightstale.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreboardTest {
    @Test
    @DisplayName("Get scoreboard entries")
    void getEntries() {
        var scoreboard = new Scoreboard();
        scoreboard.setScore("player1", 1);
        scoreboard.setScore("player2", 2);
        scoreboard.setScore("player3", 3);
        var entries = scoreboard.getEntries();
        assertEquals(3, entries.size());
        assertEquals("player1", entries.iterator().next().getKey());
    }

    @Test
    @DisplayName("Get scoreboard points of a player")
    void setPoints() {
        var scoreboard = new Scoreboard();
        scoreboard.setScore("player1", 1);
        scoreboard.setScore("player2", 2);
        scoreboard.setScore("player3", 3);
        assertEquals(1, scoreboard.getScore("player1"));
        assertEquals(2, scoreboard.getScore("player2"));
        assertEquals(3, scoreboard.getScore("player3"));
    }

    @Test
    @DisplayName("Load scoreboard from file")
    void load() {
        var scoreboard = new Scoreboard();
        scoreboard.setScore("player1", 1);
        scoreboard.setScore("player2", 2);
        scoreboard.setScore("player3", 3);
        scoreboard.save();
        var scoreboard2 = new Scoreboard();
        scoreboard2.load();
        assertEquals(1, scoreboard2.getScore("player1"));
        assertEquals(2, scoreboard2.getScore("player2"));
        assertEquals(3, scoreboard2.getScore("player3"));
    }

    @Test
    @DisplayName("Save scoreboard to file")
    void save() {
        var scoreboard = new Scoreboard();
        scoreboard.setScore("player1", 1);
        scoreboard.setScore("player2", 2);
        scoreboard.setScore("player3", 3);
        scoreboard.save();
        var path = App.getFilePath("scoreboard.json");
        assertTrue(Files.exists(path));
        var scoreboard2 = new Scoreboard();
        scoreboard2.load();
        assertEquals(1, scoreboard2.getScore("player1"));
        assertEquals(2, scoreboard2.getScore("player2"));
        assertEquals(3, scoreboard2.getScore("player3"));
    }
}
