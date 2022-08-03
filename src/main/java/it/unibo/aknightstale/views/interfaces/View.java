package it.unibo.aknightstale.views.interfaces;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.views.factories.ViewFactory;

public interface View<C extends Controller<? extends View<C>>> {
    void setController(C controller);

    void show();

    void hide();

    void close();

    String getViewName();

    String getWindowTitle();

    /**
     * Create a factory for a view.
     *
     * @param viewInterface The view interface to create the factory for.
     * @param <V>           The view interface.
     * @return The factory for the view.
     */
    static <V extends View<? extends Controller<V>>> ViewFactory<V> of(final Class<V> viewInterface) {
        return new ViewFactory<V>().fromInterface(viewInterface);
    }
}
