package ex5filehandling.f1file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/*
    Interface to file service (very good example of using interface, use interface type
    variable in program, if needed change implementation, rest of program not affected)
 */
public interface FileService {
    // NOTE: throws IOException makes caller responsible for exception handling
    List<String> readFile(Path path) throws IOException;

    void writeFile(Path path, List<String> lines) throws IOException;

    void writeObject(Path path, Object object) throws IOException;

    // Return type is Objects, must cast to real type
    Object readObject(Path path) throws IOException, ClassNotFoundException;
}
