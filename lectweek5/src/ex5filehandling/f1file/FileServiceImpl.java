package ex5filehandling.f1file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/*
    One implementation of the FileService interface

    Working with files (i.e. persistent data, data surviving the execution)
    This shows
    - How to propagate Exception (i.e. exception not handled in method, let caller handle)
    - "try with resources" (no catch) assures any resource (file) is
    released after usage (else resource leak)

    NOTE: A bit technical here but this is nothing to remember by heart
    all languages have their own (similar) ways to do it.

    DISCLAIMER: File handling in Java is messy, many ways to do it and paths
    are nightmares. Not much covered in course.

 */
public class FileServiceImpl implements FileService {

    // ---------- Text files -----------------

    // NOTE: throws IOException makes caller responsible for exception handling
    @Override
    public List<String> readFile(Path path) throws IOException {
        List<String> lines = new ArrayList<>();
         // Use try with resources to ensure stream is closed
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            // NOTE: Assignment is an expression i.e. gives a value.
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines;
        }
        // NOTE: No catch here so no exception handling here
    }

    @Override
    public void writeFile(Path path, List<String> lines) throws IOException {
        // Use try with resources to ensure stream is closed
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
         // NOTE: No catch here so no exception handling here
    }

    // ---------- Binary files -----------------

     @Override
     public void writeObject(Path path, Object object) throws IOException {
        // Write a full object (instance variables) to file
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(path))) {
            os.writeObject(object);
        }
        // NOTE: No catch here so no exception handling here
    }

    // Return type is Objects, must cast to real type
    @Override
    public Object readObject(Path path) throws IOException, ClassNotFoundException {
        // Read a full object from file
        try (ObjectInputStream is = new ObjectInputStream(Files.newInputStream(path));) {
            Object o = is.readObject();
            is.close();
            return o;
        }
    }

    public static FileService getFileService(){
        return new FileServiceImpl();  // Could send out something else (of subtype)
    }

    // Private can't use
    private FileServiceImpl(){}

}

