package it.unibo.aknightstale.controllers;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.views.interfaces.View;

@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("EI_EXPOSE_REP2")
// View must be passed as reference to allow view loader caching.
public abstract class BaseController<V extends View<? extends Controller<V>>> implements Controller<V> {
    /**
     * The view associated to this controller.
     */
    private V view;

    /**
     * Registers a view with this controller.
     * @param view the view to register.
     */
    @Override
    public void registerView(final V view) {
        this.view = view;
    }

    /**
     * Removes the view from the controller.
     */
    @Override
    public void unregisterView() {
        this.view = null;
    }

    /**
     * Shows the view.
     */
    @Override
    public void showView() {
        this.getView().show();
    }

    /**
     * Hides the view.
     */
    @Override
    public void hideView() {
        this.getView().hide();
    }

    /**
     * Closes the view.
     */
    @Override
    public void closeView() {
        this.getView().close();
    }

    /**
     * Returns the view.
     *
     * @return the view.
     */
    public V getView() {
        return this.view;
    }
}
