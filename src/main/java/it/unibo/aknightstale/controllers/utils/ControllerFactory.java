package it.unibo.aknightstale.controllers.utils;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.utils.ClassFactory;
import it.unibo.aknightstale.views.interfaces.View;
import it.unibo.aknightstale.views.utils.ViewFactory;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory<C extends Controller<V>, V extends View<C>> {
    private static final Map<Class<? extends Controller<?>>, Controller<?>> CONTROLLERS = new HashMap<>();

    private Class<C> controllerInterface;
    private Class<V> viewInterface;
    private boolean forceCreation;
    private Stage stage;

    /**
     * Clears the cache of instantiated controllers.
     */
    public static void clearCache() {
        CONTROLLERS.clear();
    }

    /**
     * Set the controller interface to search implementing class to instantiate.
     *
     * @param controllerInterface Controller interface to search implementing class to instantiate.
     * @return This instance of the factory.
     */
    public ControllerFactory<C, V> fromInterface(final Class<C> controllerInterface) {
        this.controllerInterface = controllerInterface;
        return this;
    }

    /**
     * Set the view interface to search implementing class to instantiate.
     *
     * @param viewInterface View interface to search implementing class to instantiate.
     * @return This instance of the factory.
     */
    public ControllerFactory<C, V> viewInterface(final Class<V> viewInterface) {
        this.viewInterface = viewInterface;
        return this;
    }

    /**
     * Set the factory to always create a new controller instance, even if it is already created.
     *
     * @return This instance of the factory.
     */
    public ControllerFactory<C, V> forceCreation() {
        forceCreation = true;
        return this;
    }

    /**
     * Set the stage to use to create the view associated with the controller created by the factory.
     *
     * @param stage The stage to use to create the view associated with the controller created by the factory.
     * @return This instance of the factory.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Stage is not exposed, it must be the instance passed.")
    public ControllerFactory<C, V> stage(final Stage stage) {
        this.stage = stage;
        return this;
    }

    /**
     * Creates an instance of the controller and view classes implementing the given interfaces and attaches them (view-controller and controller-view).
     *
     * @return An instance of the controller class implementing the interface.
     */
    public C get() {
        if (!forceCreation && CONTROLLERS.containsKey(controllerInterface)) {
            return controllerInterface.cast(CONTROLLERS.get(controllerInterface));
        }

        final var controller = ClassFactory.createInstanceFromInterface(controllerInterface, "controllers");
        if (viewInterface != null) {
            final var view = new ViewFactory<V>()
                    .fromInterface(viewInterface)
                    .stage(stage)
                    .get();
            controller.registerView(view);
            view.setController(controller);
        }
        CONTROLLERS.put(controllerInterface, controller);
        return controller;
    }
}
