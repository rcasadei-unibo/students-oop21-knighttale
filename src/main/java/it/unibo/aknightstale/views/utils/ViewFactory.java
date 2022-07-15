package it.unibo.aknightstale.views.utils;

import com.google.common.base.CaseFormat;
import com.simtechdata.sceneonefx.SceneOne;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.utils.ClassFactory;
import it.unibo.aknightstale.views.AlertType;
import it.unibo.aknightstale.views.JavaFXApp;
import it.unibo.aknightstale.views.interfaces.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ViewFactory {
    private static final Map<Class<? extends View<?>>, View<?>> VIEWS = new HashMap<>();

    /**
     * Creates an instance of the view class implementing the given interface.
     * @param viewInterface View interface to search implementing class to instantiate.
     * @return An instance of the view class implementing the interface.
     * @param <V> View interface type.
     */
    public <V extends View<? extends Controller<V>>> V loadView(final Class<V> viewInterface) {
        if (VIEWS.containsKey(viewInterface)) {
            return viewInterface.cast(VIEWS.get(viewInterface));
        }

        final var view = ClassFactory.createInstanceFromInterface(viewInterface, "views");
        final var viewName = view.getClass().getSimpleName();
        final var fxmlFileName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, viewName) + ".fxml";

        // Load FXML file
        final FXMLLoader fxmlLoader = new FXMLLoader(JavaFXApp.class.getResource(fxmlFileName));
        try {
            SceneOne.set(viewName, fxmlLoader.<Parent>load())
                    .title(view.getWindowTitle())
                    .build();
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
            Alert.showAlert(AlertType.ERROR, "Error loading " + fxmlFileName, e.getMessage());
            System.exit(1);
        }

        final var viewInstance = fxmlLoader.<V>getController();
        VIEWS.put(viewInterface, viewInstance);
        return viewInstance;
    }
}
