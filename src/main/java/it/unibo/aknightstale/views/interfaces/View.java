package it.unibo.aknightstale.views.interfaces;

import it.unibo.aknightstale.controllers.interfaces.Controller;

public interface View<C extends Controller<? extends View<C>>> {
    void setController(C controller);
    void show();
    void hide();
    void close();
    String getViewName();
    String getWindowTitle();
}
