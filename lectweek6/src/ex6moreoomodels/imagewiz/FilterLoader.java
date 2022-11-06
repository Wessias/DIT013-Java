package ex6moreoomodels.imagewiz;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;


/*
    Utility to create filter instances given the class names (without any suffix)

    This looks up the *.class files by name, load the classes and instantiates
    the object (filters). For all filters.

    *** THIS IS VERY SPECIAL, not included in course ****
 */
public class FilterLoader {

    private FilterLoader() {
    }

    // Package name for all filters (all filters must be in this dir)
    public static final String FILTER_DIR = "filters";
    public static final String pkg = "ex6moreoomodels.imagewiz.filters.";

    public static Filter[] getFilters(String filtersDir, String[] filterNames) {
        List<Filter> filters = new ArrayList<>();
        try {
            URL url = FilterLoader.class.getResource(filtersDir);
            // An object able to load classes
            ClassLoader cl = new URLClassLoader(new URL[]{url});
            int i = 0;
            for (String name : filterNames) {
                // Load class
                Class cls = cl.loadClass(pkg + name);
                // Instantiate without using new :-), cool... !
                filters.add((Filter) cls.getDeclaredConstructor().newInstance());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Couldn't load filters");
        }
        return filters.toArray(new Filter[]{});
    }

    // Get names for *.class files (names for the filters)
    public static String[] getFilterNames(String filtersDir) {
        URL url = FilterLoader.class.getResource(filtersDir);
        File f = new File(url.getPath());
        String[] fileNames = f.list((dir, name) -> name.endsWith(".class"));
        for (int i = 0; i < fileNames.length; i++) {
            // No .class suffix when later load classes from names (Strings)
            fileNames[i] = fileNames[i].replace(".class", "");
        }
        return fileNames;
    }

}
