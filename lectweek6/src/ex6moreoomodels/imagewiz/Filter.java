package ex6moreoomodels.imagewiz;

import javafx.scene.image.Image;

/*
    Contract for a filter. Method that any filter must have
 */
public interface Filter {
    // Image in and filtered out
    Image filter(Image in);
}
