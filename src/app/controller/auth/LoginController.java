package app.controller.auth;

import app.database.user.UserEntity;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import route.Route;
import support.View;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends AuthController {

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);

        fxSidebarButton.setText("SIGN UP");
    }

    /**
     * Invoke when the user click sign in
     *
     * @param event {@link MouseEvent}
     */
    @FXML
    private void onClickSignIn(MouseEvent event){

        final boolean idNumberIsValid = validateIdNumber();
        final boolean passwordIsValid = validatePassword();

        if (idNumberIsValid && passwordIsValid){

            UserEntity userEntities = userTable.whereIdAndPassword(fxIdNumber.getText(), fxPassword.getText());

            System.out.println(userEntities.getIdNumber());
        }
    }

    /**
     * Invoke when the user click forget password
     *
     * @param event {@link MouseEvent}
     */
    @FXML
    private void onClickForgetPassword(MouseEvent event){

        System.out.println("Forget Password");
    }

    /**
     * The sidebar button on click listener
     *
     * @param mouseEvent {@link MouseEvent}
     */
    @FXML
    @Override
    protected void onClickSidebarButton(MouseEvent mouseEvent) {

        Route.toRegistration();
    }
}
