import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static String[] readFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] lines = content.split("\n");
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static void main(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            String[] lines = readFile(fileName);
            /*if (lines != null) {
                for (String line : lines) {
                    System.out.println(line);
                }*/
            }
         else {
            System.out.println("Please give me a file name.");
        }
}}