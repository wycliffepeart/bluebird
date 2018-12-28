package app.controller.auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import route.Route;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends AuthController{

    /**
     * The user name container
     *
     * @field fxUsernameContainer {@link VBox}
     */
    @FXML
    private VBox fxUsernameContainer;

    /**
     * The username text field
     *
     * @field fxUsername {@link TextField}
     */
    @FXML
    protected TextField fxUsername;

    /**
     * The learner radio button
     *
     * @field fxLearner {@link RadioButton}
     */
    @FXML
    protected RadioButton fxLearner;

    /**
     * The role container
     *
     * @field fxRoleContainer {@link VBox}
     */
    @FXML
    protected VBox fxRoleContainer;

    /**
     * The teacher radio button
     *
     * @field fxTeacher {@link RadioButton}
     */
    @FXML
    protected RadioButton fxTeacher;

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

        fxSidebarButton.setText("SIGN IN");
    }

    /**
     * The sidebar button on click listener
     *
     * @param mouseEvent {@link MouseEvent}
     */
    @FXML
    @Override
    protected void onClickSidebarButton(MouseEvent mouseEvent) {

        Route.toLogin();
    }

    /**
     * Invoke when the user enter their username
     *
     * @param keyEvent {@link KeyEvent}
     */
    @FXML
    private void onEnterUsername(KeyEvent keyEvent){

        System.out.println(fxUsername.getText());

        if (validateUsername()) userEntity.setUsername(fxUsername.getText());
    }

    /**
     * Invoke when the user click learner
     *
     * @param event {@link ActionEvent}
     */
    @FXML
    private void onClickLearner(ActionEvent event){

        System.out.println("Learner");

        if (validateRole()) userEntity.setRole("learner");
    }

    /**
     * Invoke when the user click teacher
     *
     * @param event {@link ActionEvent}
     */
    @FXML
    private void onClickTeacher(ActionEvent event){

        System.out.println("Teacher");

        if (validateRole()) userEntity.setRole("teacher");
    }

    /**
     * Validate role
     *
     * @return {@link Boolean}
     */
    private boolean validateUsername(){

        String errorMessage = null;

        if (fxUsername.getText().length() == 0) errorMessage = "The user name is require";
        else if(fxUsername.getText().length() < 5) errorMessage = "Username must be 5 or more characters";

        return textFieldValidator(fxUsernameContainer, fxUsername, 5, errorMessage);
    }

    /**
     * Validate role
     *
     * @return {@link Boolean}
     */
    private boolean validateRole(){

        final boolean isSelected = fxLearner.isSelected() || fxTeacher.isSelected();

        if (isSelected){

            if (fxRoleContainer.getChildren().size() > 1) fxRoleContainer.getChildren().remove(1);

        }else {

            final Label label = new Label("Please select one of the options above");
            label.setStyle("-fx-text-fill: red");

            if (fxRoleContainer.getChildren().size() > 1) fxRoleContainer.getChildren().remove(1);
            fxRoleContainer.getChildren().add(1, label);
        }

        return isSelected;
    }

    /**
     * Invoke when the user click sign up
     *
     * @param event {@link MouseEvent}
     */
    @FXML
    private void onClickSignUp(MouseEvent event){

        final boolean usernameIsValid = validateUsername();
        final boolean roleIsValid = validateRole();
        final boolean idNumberIsValid = validateIdNumber();
        final boolean passwordIsValid = validatePassword();


        System.out.println(String.format("User = %b",usernameIsValid));

        if(usernameIsValid && roleIsValid && idNumberIsValid && passwordIsValid){

            System.out.println("Register");

            if (userTable.insert(userEntity) == 1){

                Route.toLogin();
            }
        }
    }
}
