package it.unibo.aknightstale.utils;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import it.unibo.aknightstale.App;
import it.unibo.aknightstale.views.AlertType;
import it.unibo.aknightstale.views.utils.Alert;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class ClassFactory {
    /**
     * Creates an instance of the class implementing the interface.
     *
     * @param interfaceClass Interface to search implementing classes to instantiate.
     * @param acceptedPackages Packages to search implementing classes in.
     * @return An instance of the class implementing the interface.
     * @param <T> Interface type.
     */
    public <T> T createInstanceFromInterface(final Class<T> interfaceClass, final String... acceptedPackages) {
        String className;
        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages(absolutizePackageNames(acceptedPackages))
                .scan()) {
            ClassInfoList implementations = scanResult.getClassesImplementing(interfaceClass);
            if (implementations.isEmpty()) {
                var message = "No implementation of " + interfaceClass.getCanonicalName() + " found in packages " + Arrays.toString(absolutizePackageNames(acceptedPackages));
                Alert.showAlert(AlertType.ERROR, "Error", "No implementation found", message);
                throw new RuntimeException();
            }

            className = implementations.get(0).getName();
        }

        try {
            return interfaceClass.cast(Class.forName(className).getConstructor().newInstance());
        } catch (Exception e) {
            var message = "Error instantiating " + interfaceClass.getName() + ": " + e.getMessage();
            Alert.showAlert(AlertType.ERROR, "Error", "Error instantiating", message);
            throw new RuntimeException(message);
        }
    }

    private String[] absolutizePackageNames(final String[] packageNames) {
        return Arrays.stream(packageNames)
                .map((packageName) -> packageName.contains(App.APP_PACKAGE) ? packageName : App.APP_PACKAGE + "." + packageName)
                .toArray(String[]::new);
    }
}
