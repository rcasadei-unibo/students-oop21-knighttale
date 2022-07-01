package it.unibo.aknightstale.views.utils;

import it.unibo.aknightstale.views.AlertType;

public class Alert {
    public static void showAlert(final AlertType type, final String title, final String header, final String content) {
        var alert = new javafx.scene.control.Alert(type.getAlertType(), content);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    public static void showAlert(final AlertType type, final String content) {
        showAlert(type, "", "", content);
    }

    public static void showAlert(final AlertType type, final String title, final String content) {
        showAlert(type, title, "", content);
    }
}
