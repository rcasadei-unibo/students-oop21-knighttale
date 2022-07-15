package it.unibo.aknightstale.views.utils;

import it.unibo.aknightstale.views.AlertType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Alert {
    /**
     * Shows an alert.
     *
     * @param type Alert type.
     * @param title Alert dialog title.
     * @param header Alert header text.
     * @param content Alert message.
     */
    public void showAlert(final AlertType type, final String title, final String header, final String content) {
        final var alert = new javafx.scene.control.Alert(type.getAlertType(), content);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    /**
     * Shows an alert with the given type, title, header and content.
     * @param type Alert type.
     * @param content Alert message.
     */
    public void showAlert(final AlertType type, final String content) {
        showAlert(type, "", "", content);
    }

    /**
     * Shows an alert with the given type, title, header and content.
     * @param type Alert type.
     * @param title Alert dialog title.
     * @param content Alert text.
     */
    public void showAlert(final AlertType type, final String title, final String content) {
        showAlert(type, title, "", content);
    }
}
