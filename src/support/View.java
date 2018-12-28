package support;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class View {

    /**
     * Retrieve the application primary stage
     *
     * @return {@link Stage}
     */
    public static Stage getPrimaryStage() {

        return (Stage) Stage.getWindows().get(0);
    }

    /**
     * Show dialog
     *
     * @param alertType   The alert type
     * @param title       The alert  title
     * @param headerText  The alert header message
     * @param contentText The alert content
     */
    public static void dialog(Alert.AlertType alertType, String title, String headerText, String contentText) {

        Alert alert = new Alert(alertType);

        alert.setTitle(title);

        alert.setHeaderText(headerText);

        alert.setContentText(contentText);

        alert.showAndWait();
    }

    /**
     * Route the application to a scene
     *
     * @param name       The name of the scene
     * @param layout     The name of the layout
     * @param controller The name of the controller
     */
    public static void scene(String name, String layout, Object controller) {

        try {

            // Retrieve the primary stage
            Stage primaryStage = getPrimaryStage();

            // Inflate the toDashboard layout
            Scene scene = FXMLInflater.inflate(layout, controller);

            //
            primaryStage.setTitle(name);

            // Assign a new scene on the primary stage
            primaryStage.setScene(scene);

            // Display the newly assigned scene
            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    /**
     * Route the application to a scene
     *
     * @param name       The name of the scene
     * @param layout     The name of the layout
     * @param controller The name of the controller
     */
    public static void scene(Stage stage, String name, String layout, Object controller) {

        try {

            // Inflate the toDashboard layout
            Scene scene = FXMLInflater.inflate(layout, controller);

            //
            stage.setTitle(name);

            // Assign a new scene on the primary stage
            stage.setScene(scene);

            // Display the newly assigned scene
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    /**
     * Route the application to a modal
     *
     * @param name       The name of the modal
     * @param layoutName The name off the layout
     * @param controller The name of the controller
     */
    public static void model(String name, String layoutName, Object controller) {

        try {

            Stage window = new Stage();
            window.setResizable(false);
            window.initModality(Modality.APPLICATION_MODAL);
//        window.getIcons().add(ROld.image("identicon.png"));

            window.setScene(R.inflate(layoutName, controller));

            window.setTitle(name);
            window.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
