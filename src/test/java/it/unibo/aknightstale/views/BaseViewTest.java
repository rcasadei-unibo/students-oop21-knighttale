package it.unibo.aknightstale.views;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.controllers.factories.ControllerFactory;
import it.unibo.aknightstale.views.interfaces.View;
import it.unibo.aknightstale.views.factories.ViewFactory;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.TimeoutException;

import static org.testfx.api.FxToolkit.registerPrimaryStage;

@SuppressFBWarnings("EI_EXPOSE_REP") // View must be passed as reference to allow view loader caching.
@ExtendWith(ApplicationExtension.class)
public abstract class BaseViewTest<C extends Controller<V>, V extends View<C>> {
    private V view;
    private C controller;

    @BeforeAll
    public static void setupSpec() throws TimeoutException {
        if (Boolean.getBoolean("headless")) {
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("java.awt.headless", "true");
            System.setProperty("testfx.setup.timeout", "2500");
        }
        registerPrimaryStage();
    }

    /**
     * Starts the JavaFX application.
     *
     * @param stage JavaFX app stage.
     */
    @Start
    public void start(final Stage stage) {
        // Clear cache when starting a new test set.
        this.clearCache();
        WaitForAsyncUtils.waitForFxEvents();
        this.controller = Controller.of(this.getControllerInterface(), this.getViewInterface())
                .stage(stage)
                .get();
        this.controller.showView();
        this.view = View.of(this.getViewInterface()).get();
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

    /**
     * Clears the cache of instantiated controllers and views.
     */
    protected void clearCache() {
        ViewFactory.clearCache();
        ControllerFactory.clearCache();
    }
}
