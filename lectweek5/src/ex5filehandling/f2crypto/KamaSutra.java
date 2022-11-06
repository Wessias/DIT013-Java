package ex5filehandling.f2crypto;

import ex5filehandling.f1file.FileService;
import ex5filehandling.f1file.FileServiceImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

/*
     Kama Sutra cipher (using the FileService)
     Demo of file handling (files used are in resources/files)
     NOTE: Seems to have some issues (text not perfectly decoded)

     Run like

        en = Encode
        de = Decode
        > en
        File name > msg.plain
        Done   (check resources/files/msg.cipher)

 */
public class KamaSutra {

    public static void main(String[] args) {
        new KamaSutra().program();
    }

    // Path's in Java is an extremely UGLY topic (this is for now)
    private final String RESOURCES = "resources/files/";

    // The alphabet used in messages (plain and encrypted). NOTE: Even number of chars
    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz.,:?! ";
    private Scanner sc = new Scanner(in);

    private void program() {

        // Prepare the keys
        String shuffle = shuffle(alphabet);
        String key1 = shuffle.substring(0, shuffle.length() / 2);
        String key2 = shuffle.substring(shuffle.length() / 2);

        out.print("en = Encode\nde = Decode\n> ");
        String select = sc.nextLine();
        out.print("File name > ");
        String infile = sc.nextLine();

         // Interface variable
        FileService fs = FileServiceImpl.getFileService();
        List<String> lines = null;
        try {
            Path path = Paths.get(RESOURCES + infile);
            lines = fs.readFile(path);
        } catch (IOException e) {
            out.println(e.getMessage());
        }
        int i = infile.indexOf(".");
        String outfile = null;
        switch (select) {         // No real checks of user input
            case "en":
                outfile = infile.substring(0, i) + ".cipher";
                lines = encodeAll(lines, key1, key2);
                lines.add(0, key1);  // Add keys first in message
                lines.add(1, key2);
                break;
            case "de":
                outfile = infile.substring(0, i) + ".plain";
                key1 = lines.get(0);   // Read keys from message
                key2 = lines.get(1);
                lines = decodeAll(lines.subList(2, lines.size()), key1, key2);
                break;
            default:
                out.println("Unknown option");

        }
        // Write result (plain or cipher)
        try {
            Path path = Paths.get(RESOURCES + outfile);
            fs.writeFile(path, lines);
        } catch (IOException e) {
            out.println(e.getMessage());
        }
        out.println("Done");
    }

    // ----------- Methods -------------------------

    private List<String> encodeAll(List<String> lines, String key1, String key2) {
        List<String> encoded = new ArrayList<>();
        for (String line : lines) {
            // NOTE: toLowerCase
            encoded.add(encode(line.toLowerCase(), key1, key2));
        }
        return encoded;
    }

    private String encode(String plainText, String key1, String key2) {
        StringBuilder sb = new StringBuilder();
        for (char ch : plainText.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                int i = key1.indexOf(ch);
                if (i >= 0) {
                    sb.append(key2.charAt(i));
                } else {
                    i = key2.indexOf(ch);
                    sb.append(key1.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    private List<String> decodeAll(List<String> lines, String key1, String key2) {
        List<String> decoded = new ArrayList<>();
        for (String line : lines) {
            decoded.add(decode(line, key1, key2));
        }
        return decoded;
    }

    private String decode(String crypto, String key1, String key2) {
        StringBuilder sb = new StringBuilder();
        for (char ch : crypto.toCharArray()) {
            int i = key1.indexOf(ch);
            if (i >= 0) {
                sb.append(key2.charAt(i));
            } else {
                i = key2.indexOf(ch);
                sb.append(key1.charAt(i));
            }
        }
        return sb.toString();
    }



    private String shuffle(String alphabet) {
        List<String> strs = Arrays.asList(alphabet.split(""));
        Collections.shuffle(strs);
        return String.join("", strs);
    }


}






