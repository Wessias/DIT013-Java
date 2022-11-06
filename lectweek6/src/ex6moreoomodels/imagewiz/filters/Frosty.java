package ex6moreoomodels.imagewiz.filters;


import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import ex6moreoomodels.imagewiz.AbstractFilter;


import java.util.Random;

/**
 * Filter that makes images look like viewed through a frosty window
 */
public class Frosty extends AbstractFilter {

    private static final Random rand = new Random();

    @Override
    protected void doFilter(PixelWriter writer, PixelReader reader, int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color oldC = reader.getColor(x, y);
                int i = x + getOffset();
                int j = y + getOffset();
                if (0 < i && i < width && 0 < j && j < height) {
                    Color offsetC = reader.getColor(i, j);
                    int[] rgb = toRgb(offsetC);
                    Color newC = Color.rgb(rgb[0], rgb[1], rgb[2]);
                    writer.setColor(x, y, newC);
                } else {
                    writer.setColor(x, y, oldC);
                }
            }
        }
    }

    // Get point random x andy y +/-0-5 pixel away
    private int getOffset() {
        int i = rand.nextInt(6);
        if (rand.nextBoolean()) {
            return i;
        } else {
            return -i;
        }
    }

}
