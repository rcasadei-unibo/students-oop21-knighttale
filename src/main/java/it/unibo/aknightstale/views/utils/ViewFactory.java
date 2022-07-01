package it.unibo.aknightstale.views.utils;

import com.google.common.base.CaseFormat;
import com.simtechdata.sceneonefx.SceneOne;
import it.unibo.aknightstale.controllers.interfaces.Controller;
import it.unibo.aknightstale.utils.ClassFactory;
import it.unibo.aknightstale.views.JavaFXApp;
import it.unibo.aknightstale.views.interfaces.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewFactory {
    private static final Map<Class<? extends View<?>>, View<?>> VIEWS = new HashMap<>();
    public static <V extends View<? extends Controller<V>>> V loadView(final Class<V> viewInterface) {
        if (VIEWS.containsKey(viewInterface)) {
            return viewInterface.cast(VIEWS.get(viewInterface));
        }

        var view = ClassFactory.createInstanceFromInterface(viewInterface, "views");
        var viewName = view.getClass().getSimpleName();
        var fxmlFileName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, viewName) + ".fxml";

        // Load FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFXApp.class.getResource(fxmlFileName));
        try {
            SceneOne.set(viewName, fxmlLoader.<Parent>load())
                    .title(view.getWindowTitle())
                    .build();
        } catch (IOException | IllegalStateException e) {
            var alert = new Alert(Alert.AlertType.ERROR, "Error loading " + fxmlFileName + ": " + e.getMessage());
            e.printStackTrace();
            alert.showAndWait();
            System.exit(1);
        }

        var viewInstance = fxmlLoader.<V>getController();
        VIEWS.put(viewInterface, viewInstance);
        return viewInstance;
    }
}
