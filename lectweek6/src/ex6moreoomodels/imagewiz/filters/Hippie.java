package ex6moreoomodels.imagewiz.filters;


import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import ex6moreoomodels.imagewiz.AbstractFilter;


/**
 *   Hippie filter
 */
public class Hippie extends AbstractFilter {

    @Override
    protected void doFilter(PixelWriter writer, PixelReader reader, int width, int height) {
        for (int y = 0; y < height ; y++) {
            for (int x = 0; x < width; x++) {
                Color oldC = reader.getColor(x,y);
                int[] rgb = toRgb(oldC);
                rgb[0] = doR(rgb);
                rgb[1] = doG(rgb);
                rgb[2] = doB(rgb);
                Color newC = Color.rgb(rgb[0], rgb[1], rgb[2]);
                writer.setColor(x, y, newC);
            }
        }
    }

    private int doR(int[] rgb) {
        return  (rgb[0] + rgb[1]) % 255;
    }

    private int doG(int[] rgb) {
        return  (rgb[1] + rgb[2]) % 255;
    }

    private int doB(int[] rgb) {
        return  (rgb[0] + rgb[2]) % 255;
    }
}
