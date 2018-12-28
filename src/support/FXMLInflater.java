package support;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FXMLInflater {

    /**
     * The layouts path attribute
     */
    public static final String LAYOUT_PATH = String.format("%s%s%s%s%s", "src", File.separator, "resources", File.separator, "layouts");

    /**
     * Inflate and bind a controller to the layout
     *
     * @param layoutName   The file to load
     * @return {@link Scene}
     * @throws IOException IOException
     */
    public static Scene inflate(final String layoutName) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getLayoutURL(layoutName));

        return new Scene(fxmlLoader.load());
    }

    /**
     * Inflate and bind a controller to the layout
     *
     * @param layoutName      The file to load
     * @param controller The controller to bindFxml
     * @return {@link Scene}
     * @throws IOException IOException
     */
    public static Scene inflate(final String layoutName, final Object controller) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getLayoutURL(layoutName));

        fxmlLoader.setController(controller);

        return new Scene(fxmlLoader.load());
    }

    /**
     *  Retrieve the layout url
     *
     * @param layoutName  The name of the layout
     * @return {@link URL} The url object
     * @throws MalformedURLException throws exception
     */
    private static URL getLayoutURL(final String layoutName) throws MalformedURLException {

        File file = new File(String.format("%s%s%s%s", LAYOUT_PATH, File.separator, layoutName, ".fxml"));

        return file.toURI().toURL();
    }
}
