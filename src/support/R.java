package support;

import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

public class R {

    /**
     * Retrieve a image resource
     *
     * @param name {@link String}
     * @return {@link Image}
     */
    public static Image image(String name) {

        return new Image(lookup("images", name).getAbsolutePath());
    }

    /**
     * Lookup a file and return it
     *
     * @param folder {@link String}
     * @param filename {@link String}
     * @return {@link File}
     */
    public static File lookup(String folder, String filename){

        // TODO implement a file not found exception

        return new File(String.format("%s%s%s%s%s%s%s", "src", File.separator, "resources", File.separator, folder, File.separator, filename));
    }

    /**
     * Bind the layout to a controller
     *
     * @param layoutName   The file to load
     * @param controller The controller to bindFxml
     * @return {@link Scene}
     * @throws IOException IOException
     */
    public static Scene inflate(final String layoutName, final Object controller) throws IOException {

        return FXMLInflater.inflate(layoutName, controller);
    }

    /**
     *
     * @param styleName {@link String}
     * @return {@link String}
     */
    public static String style(final String styleName){

        return lookup("styles", styleName).getAbsolutePath();
    }
}
