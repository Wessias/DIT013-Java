package ex6moreoomodels.imagewiz;


import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/*
      Abstract base class for filters, handling all common code
 */
public abstract class AbstractFilter implements Filter {

    @Override
    public Image filter(Image in) {
        int w = (int) in.getWidth();
        int h = (int) in.getHeight();
        WritableImage out = new WritableImage(w, h);
        PixelReader reader = in.getPixelReader();
        PixelWriter writer = out.getPixelWriter();

        // Must be implemented by any filter
        doFilter(writer, reader, w, h);

        return out;
    }

    // Subclasses (filters) must override
    protected abstract void doFilter(PixelWriter writer, PixelReader reader, int width, int height);

    // Utilities only accessible to sub classes
    protected int toRgb(double rgb) {
        return (int) (rgb * 255);
    }

    protected int[] toRgb(Color c) {
        return new int[]{(int) (c.getRed() * 255), (int) (c.getGreen() * 255), (int) (c.getBlue() * 255)};
    }

}
