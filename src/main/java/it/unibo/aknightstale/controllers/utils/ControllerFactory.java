package it.unibo.aknightstale.controllers.utils;

import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.utils.ClassFactory;
import it.unibo.aknightstale.views.interfaces.View;
import it.unibo.aknightstale.views.utils.ViewFactory;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
    private static final Map<Class<? extends Controller<?>>, Controller<?>> CONTROLLERS = new HashMap<>();
    public static <V extends View<C>, C extends Controller<V>> C createController(final Class<C> controllerInterface, final Class<V> viewInterface) {
        if (CONTROLLERS.containsKey(controllerInterface)) {
            return controllerInterface.cast(CONTROLLERS.get(controllerInterface));
        }

        var controller = ClassFactory.createInstanceFromInterface(controllerInterface, "controllers");
        if (viewInterface != null) {
            var view = ViewFactory.loadView(viewInterface);
            controller.registerView(view);
            view.setController(controller);
        }
        CONTROLLERS.put(controllerInterface, controller);
        return controller;
    }

    public static <V extends View<C>, C extends Controller<V>> C createController(final Class<C> controllerInterface) {
        return createController(controllerInterface, null);
    }
}
