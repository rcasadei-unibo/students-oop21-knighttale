package it.unibo.aknightstale;

import it.unibo.aknightstale.views.JavaFXApp;
import javafx.application.Application;
import net.harawata.appdirs.AppDirsFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main application entry-point.
 */
public final class App {
    /** App name. */
    public static final String APP_NAME = "A Knight's Tale";
    /** App version. */
    public static final String APP_VERSION = "0.1.0";
    /** App package. */
    public static final String APP_PACKAGE = "it.unibo.aknightstale";

    private App() {
        // Main entry-point.
    }

    public static void main(final String[] args) {
        Application.launch(JavaFXApp.class, args);
    }

    public static Path getFilePath(final String... pathsToAppend) {
        var appDir = AppDirsFactory.getInstance().getUserDataDir(APP_NAME, APP_VERSION, "unibo", true);

        if (Boolean.getBoolean("headless")) {
            appDir = Paths.get("build").toAbsolutePath().toString();
        }

        return Paths.get(appDir, pathsToAppend);
    }

    public static Path getFilePath(final Path pathToAppend) {
        return getFilePath().resolve(pathToAppend);
    }
}
