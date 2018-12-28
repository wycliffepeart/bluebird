package app.bootstrap;

import javafx.application.Application;
import javafx.stage.Stage;

import route.Route;

public class BluebirdApplication extends Application {

    /**
     * The application entry point
     *
     * @param args {@link String[]}
     */
    public static void main(String[] args) {

        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        Route.toLogin(primaryStage);
    }
}
