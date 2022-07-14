package it.unibo.aknightstale.views;

import com.simtechdata.sceneonefx.SceneOne;
import it.unibo.aknightstale.views.interfaces.View;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Window {
    private final String windowId;
    private View<?> view;
    private Boolean isOpen = false;

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

    /**
     * Open the window.
     */
    public void open() {
        SceneOne.show(this.windowId);
        this.isOpen = true;
    }

    /**
     * Close the window.
     */
    public void close() {
        SceneOne.close(this.windowId);
        this.isOpen = false;
    }

    /**
     * Close the window only if the view showing is the given one.
     *
     * @param view View to check if it's showing in the window.
     */
    public void close(final @NotNull View<?> view) {
        if (view.getViewName().equals(this.getCurrentViewName())) {
            this.close();
        }
    }

    /**
     * Hide the window.
     */
    public void hide() {
        SceneOne.hide(this.windowId);
        this.isOpen = false;
    }

    /**
     * Hide the window only if the view showing is the given one.
     *
     * @param view View to check if it's showing in the window.
     */
    public void hide(final @NotNull View<?> view) {
        if (view.getViewName().equals(this.getCurrentViewName())) {
            this.hide();
        }
    }

    /**
     * Unhide the window.
     */
    public void unhide() {
        SceneOne.unHide(this.windowId);
        this.isOpen = true;
    }

    /**
     * Get the current view showing in the window.
     * @return Current view.
     */
    public View<?> getCurrentView() {
        return view;
    }

    /**
     * Get the name of the current view showing in the window.
     * @return Current view name.
     */
    public String getCurrentViewName() {
        return view.getViewName();
    }

    /**
     * Checks if the window is open.
     * @return true if the window is open, false otherwise.
     */
    public Boolean isOpened() {
        return isOpen;
    }
}
