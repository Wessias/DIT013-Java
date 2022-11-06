package ex6moreoomodels.imagewiz.filters;


import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import ex6moreoomodels.imagewiz.AbstractFilter;

import java.util.Random;

/**
 *    Show how easy to add filters
 */

public class Junk extends AbstractFilter {

    private static final Random rand = new Random();

    @Override
    protected void doFilter(PixelWriter writer, PixelReader reader, int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color oldC = reader.getColor(x, y);
                int[] rgb = toRgb(oldC);
                Color newC = Color.rgb((rgb[0]+rgb[1])/2, (rgb[1]+rgb[2])/2, (rgb[2]+rgb[1])/2);
                writer.setColor(x, y, newC);

            }
        }
    }


}
