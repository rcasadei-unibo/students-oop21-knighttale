package it.unibo.aknightstale.views;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.utils.ControllerFactory;
import it.unibo.aknightstale.views.interfaces.View;
import it.unibo.aknightstale.views.utils.ViewFactory;
import javafx.stage.Stage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@SuppressFBWarnings("EI_EXPOSE_REP") // View must be passed as reference to allow view loader caching.
@ExtendWith(ApplicationExtension.class)
public abstract class BaseViewTest<C extends Controller<V>, V extends View<C>> {
    private V view;
    private C controller;

    /**
     * Starts the JavaFX application.
     *
     * @param stage JavaFX app stage.
     */
    @Start
    public void start(final Stage stage) {
        this.controller = ControllerFactory.createController(getControllerInterface(), getViewInterface());
        this.controller.showView();
        this.view = ViewFactory.loadView(getViewInterface());
    }

    public abstract Class<V> getViewInterface();

    public abstract Class<C> getControllerInterface();

    /**
     * Get the view.
     *
     * @return view.
     */
    public V getView() {
        return this.view;
    }

    /**
     * Get the view.
     *
     * @return view.
     */
    public <T extends BaseView<C>> T getView(final Class<T> viewClass) {
        return viewClass.cast(view);
    }

    /**
     * Get view controller.
     *
     * @return controller.
     */
    public C getController() {
        return controller;
    }

    /**
     * Get the window related to the view of this test.
     *
     * @return window instance.
     */
    public Window getWindow() {
        return ((BaseView<?>) getView()).getWindow();
    }
}
