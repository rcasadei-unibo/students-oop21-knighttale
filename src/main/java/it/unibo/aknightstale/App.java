package it.unibo.aknightstale;

import it.unibo.aknightstale.views.JavaFXApp;
import javafx.application.Application;
import net.harawata.appdirs.AppDirsFactory;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main application entry-point.
 */
public final class App {
    /** APP NAME. */
    public static final String APP_NAME = "A Knight's Tale";
    /** APP VERSION. */
    public static final String APP_VERSION = "0.1.0";
    public static final String APP_PACKAGE = "it.unibo.aknightstale";

    public static void main(final String[] args) {
        Application.launch(JavaFXApp.class, args);
    }

    public static @NotNull Path getFilePath(final String... pathsToAppend) {
        return Paths.get(AppDirsFactory.getInstance().getUserDataDir(APP_NAME, APP_VERSION, "unibo", true), pathsToAppend);
    }

    public static @NotNull Path getFilePath(final Path pathToAppend) {
        return getFilePath().resolve(pathToAppend);
    }
}
