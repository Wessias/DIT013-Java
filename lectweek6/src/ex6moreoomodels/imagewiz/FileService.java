package ex6moreoomodels.imagewiz;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/*
        Simple (static) service for loading and saving images
 */
public class FileService {

    private FileService() {
    }

    public static Image load(File file) {
        return new Image(file.toURI().toString());
    }

    public static void save(File file, Image img) throws IOException {
        ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", file);
    }

}
