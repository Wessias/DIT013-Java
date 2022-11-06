package ex6moreoomodels.imagewiz.filters;


import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import ex6moreoomodels.imagewiz.AbstractFilter;


/**
 * Make image look old
 */

public class Sepia extends AbstractFilter {


    @Override
    protected void doFilter(PixelWriter writer, PixelReader reader, int width, int height) {
        int sepiaDepth = 20;
        int sepiaIntensity = 35;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color cOld = reader.getColor(x, y);
                int r = toRgb(cOld.getRed());
                int g = toRgb(cOld.getGreen());
                int b = toRgb(cOld.getBlue());
                int wSum = getWeightedSum(r, g, b);
                r = wSum + 2 * sepiaDepth;
                g = wSum + sepiaDepth;
                b = wSum;
                // Normalize
                if (r > 255) {
                    r = 255;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b > 255) {
                    b = 255;
                }
                b -= sepiaIntensity;
                if (b < 0) {
                    b = 0;
                }
                if (b > 255) {
                    b = 255;
                }
                Color cNew = Color.rgb(r, g, b);
                writer.setColor(x, y, cNew);
            }
        }
    }

    private int getWeightedSum(int r, int g, int b) {
        return (int) (0.21 * r + 0.72 * g + 0.07 * b);
    }

}

