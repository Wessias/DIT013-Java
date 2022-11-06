package ex5filehandling.f1file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.out;

/*

    Testing the FileService
    Run this and inspect junk.txt and pelle.ser (.ser are binary files)

    NOTE: All files in resources/files directory

 */
public class TestFileService {

    public static void main(String[] args) {
        new TestFileService().test();
    }

    // Path's in Java is an extremely UGLY topic (this is for now)
    private final String RESOURCES = "resources/files/";
    private void test() {
        List<String> data = List.of("aaa", "bbb", "ccc", "ddd", "eee"); // Data to write

        // Interface variable
        FileService fs = FileServiceImpl.getFileService();
        try {
            Path path = Paths.get(RESOURCES + "junk.txt" );
            // Use FileService
            fs.writeFile(path, data);
            List<String> copy = fs.readFile(path);
            boolean b = true;
            // Check that what read is same as what we wrote
            for (int i = 0; i < data.size(); i++) {
                b = b && data.get(i).equals(copy.get(i));
            }
            out.println(b);
        } catch (IOException e) {  // Must handle checked exception
            e.printStackTrace();
        }

        // Object to store
        MyClass o = new MyClass("pelle");
        try {
            Path path = Paths.get(RESOURCES + "pelle.ser");
            fs.writeObject(path, o);        // Write full object to file
            MyClass o1 = (MyClass) fs.readObject(path);   // Read object back
            out.println(o.getName().equals(o1.getName())); // Same content ...
            out.println(o != o1);                          // ...but other object!
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
