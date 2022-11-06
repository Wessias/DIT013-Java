package ex6moreoomodels.imagewiz;

import javafx.scene.image.Image;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/*
     Logic for the image (handling) wizard program.
 */
public class ImageWiz {

    // This is a stack used for undo operations
    private final Deque<Image> undoStack = new ArrayDeque<>();
    // Make it possible to lookup a filter given a name
    private final Map<String, Filter> nameFilter;
    private Image actual;

    public ImageWiz(Map<String, Filter> nameFilter){
        this.nameFilter = nameFilter;
    }

    public Image apply(String filterName) {
        if (actual != null) {
            undoStack.push(actual);
            actual = nameFilter.get(filterName).filter(actual);
        }
        return actual;
    }

    // Revert last applied filter
    public Image undo() {
        if (!undoStack.isEmpty()) {
            actual = undoStack.pop();
        }
        return actual;
    }

    public Image getActual(){
        return actual;
    }

    public void setActual( Image actual){
        this.actual = actual;
    }

}
