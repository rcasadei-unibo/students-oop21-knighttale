package it.unibo.aknightstale.views;

import com.simtechdata.sceneonefx.SceneOne;
import it.unibo.aknightstale.views.interfaces.View;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Window {
    private final String windowId;
    private View<?> view;

    public Window() {
        this(UUID.randomUUID().toString());
    }

    public Window(final String windowId) {
        this.windowId = windowId;
        SceneOne.set(this.windowId, new javafx.scene.Scene(new VBox())).build();
    }

    /**
     * Switch the scene in the window.
     */
    public void switchTo(final @NotNull View<?> view) {
        var scene = SceneOne.getScene(view.getClass().getSimpleName());
        SceneOne.swapScene(this.windowId, scene);
        SceneOne.setTitle(this.windowId, view.getWindowTitle());
        this.view = view;
    }

    public void open() {
        SceneOne.show(this.windowId);
    }

    public void close() {
        SceneOne.close(this.windowId);
    }

    public void close(final @NotNull View<?> view) {
        if (view.getViewName().equals(this.getCurrentViewName())) {
            this.close();
        }
    }

    public void hide() {
        SceneOne.hide(this.windowId);
    }

    public void hide(final @NotNull View<?> view) {
        if (view.getViewName().equals(this.getCurrentViewName())) {
            this.hide();
        }
    }

    public void unhide() {
        SceneOne.unHide(this.windowId);
    }

    public View<?> getCurrentView() {
        return view;
    }

    public String getCurrentViewName() {
        return view.getViewName();
    }
}
