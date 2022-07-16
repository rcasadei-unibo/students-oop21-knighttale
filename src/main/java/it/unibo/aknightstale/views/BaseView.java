package it.unibo.aknightstale.views;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.views.interfaces.View;

public abstract class BaseView<C extends Controller<? extends View<C>>> implements View<C> {
    /**
     * Controller that is associated with this view.
     */
    private C controller;
    private Window window;

    BaseView() {
        this(Window.getOrCreate("main_window"));
    }

    BaseView(final Window window) {
        this.window = window;
    }

    /**
     * Gets the controller associated with this view.
     *
     * @return the controller associated with this view.
     */
    protected C getController() {
        return controller;
    }

    /**
     * Sets the controller associated with this view.
     * @param controller the controller to associate with this view.
     */
    @Override
    public void setController(final C controller) {
        this.controller = controller;
    }

    /**
     * Shows the view.
     */
    @Override
    public void show() {
        this.getWindow().switchTo(this);
        this.getWindow().open();
    }

    /**
     * Hides the view.
     */
    @Override
    public void hide() {
        this.getWindow().hide(this);
    }

    /**
     * Closes the view.
     */
    @Override
    public void close() {
        this.getWindow().close(this);
    }

    /**
     * Gets the window associated with this view.
     * @return the window associated with this view.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Sets the window associated with this view.
     * @param window the window to associate with this view.
     */
    public void setWindow(final Window window) {
        this.window = window;
    }

    /**
     * Gets the name of the view.
     * @return the name of the view.
     */
    @Override
    public String getViewName() {
        return this.getClass().getSimpleName();
    }
}
