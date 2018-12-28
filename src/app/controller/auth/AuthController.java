package app.controller.auth;

import app.database.user.UserEntity;
import app.database.user.UserTable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class AuthController implements Initializable {

    /**
     * The id field container
     *
     * @field fxIdFieldContainer {@link VBox}
     */
    @FXML
    private VBox fxIdFieldContainer;

    /**
     * The user id number text field
     *
     * @field fxIdNumber {@link TextField}
     */
    @FXML
    protected TextField fxIdNumber;

    /**
     * The password container
     *
     * @field fxPasswordContainer {@link VBox}
     */
    @FXML
    protected VBox fxPasswordContainer;

    /**
     * The user password field
     *
     * @field fxPassword {@link PasswordField}
     */
    @FXML
    protected PasswordField fxPassword;

    /**
     * The button use to submit user credentials
     *
     * @field fxSubmitButton {@link Button}
     */
    @FXML
    protected Button fxSubmitButton;

    /**
     * The button use to toggle between login and registration
     *
     * @field fxSidebarButton {@link Button}
     */
    @FXML
    Button fxSidebarButton;

    /**
     * The user table
     *
     * @field userTable {@link UserTable}
     */
    protected UserTable userTable;

    /**
     * The user entity
     *
     * @field userEntity {@link UserEntity}
     */
    protected UserEntity userEntity;

    /**
     * The default constructor
     */
    public AuthController() {

        userTable = new UserTable();
        userEntity = new UserEntity();
    }

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

    }

    /**
     * Invoke when the user enter their id number
     *
     * @param keyEvent {@link KeyEvent}
     */
    @FXML
    private void onEnterIdNumber(KeyEvent keyEvent) {

        System.out.println(fxIdNumber.getText());

        if (validateIdNumber()) userEntity.setIdNumber(fxIdNumber.getText());
    }

    /**
     * Validate the id number
     *
     * @return {@link Boolean}
     */
    protected boolean validateIdNumber() {

        final boolean isEmpty = fxIdNumber.getText().length() == 0;

        final String errorMessage = isEmpty ? "Id number is required" : "Id number should be 6 or more characters";

        return textFieldValidator(fxIdFieldContainer, fxIdNumber, 7, errorMessage);
    }

    /**
     * Invoke when the user enter their password
     *
     * @param keyEvent {@link KeyEvent}
     */
    @FXML
    private void onEnterPassword(KeyEvent keyEvent) {

        System.out.println(fxPassword.getText());

        if (validatePassword()) userEntity.setPassword(fxPassword.getText());

    }

    /**
     * Validate the password
     *
     * @return {@link Boolean}
     */
    protected boolean validatePassword() {

        final boolean isEmpty = fxPassword.getText().length() == 0;

        final String errorMessage = isEmpty ? "Password is required" : "Password should be 4 or more characters";

        return textFieldValidator(fxPasswordContainer, fxPassword, 4, errorMessage);
    }

    /**
     * Validate text field
     *
     * @param container  {@link VBox}
     * @param textField  {@link TextField}
     * @param charLength {@link Integer}
     * @return {@link Boolean}
     */
    protected boolean textFieldValidator(VBox container, TextField textField, int charLength, String errorMessage) {

        boolean success = false;

        if (textField.getText().length() < charLength) {

            final Label label = new Label(errorMessage);
            label.setStyle("-fx-text-fill: red");

            if (container.getChildren().size() > 1) container.getChildren().remove(1);
            container.getChildren().add(1, label);

        } else {

            if (container.getChildren().size() > 1) container.getChildren().remove(1);

            success = true;
        }

        return success;
    }

    /**
     * The sidebar button on click listener
     *
     * @param mouseEvent {@link MouseEvent}
     */
    protected abstract void onClickSidebarButton(MouseEvent mouseEvent);
}
