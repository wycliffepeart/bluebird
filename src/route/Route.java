package route;

import support.View;
import javafx.stage.Stage;

import app.controller.auth.LoginController;
import app.controller.auth.RegistrationController;

public class Route {

    /**
     * Route the application to login
     *
     * @param stage {@link Stage}
     */
    public static void toLogin(Stage stage) {

        View.scene(stage, "User Login", "auth_signin_layout", new LoginController());
    }

    /**
     * Route the application to login
     */
    public static void toLogin() {

        View.scene("User Login", "auth_signin_layout", new LoginController());
    }

    /**
     * Route the application to registration
     */
    public static void toRegistration() {

        View.scene("User Registration", "auth_signup_layout", new RegistrationController());
    }
}
