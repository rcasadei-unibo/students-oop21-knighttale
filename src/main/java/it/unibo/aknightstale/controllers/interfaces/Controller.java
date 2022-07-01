package it.unibo.aknightstale.controllers.interfaces;

import it.unibo.aknightstale.views.interfaces.View;

public interface Controller<V extends View<? extends Controller<V>>> {
    void registerView(V view);
    void unregisterView();

    void showView();
    void hideView();
    void closeView();
}
