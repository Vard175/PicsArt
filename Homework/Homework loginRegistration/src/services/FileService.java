package services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class FileService {

    public static void write(String path, String text) {
        try {
            Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap read(String path) throws IOException {
        var read = Files.readAllLines(Paths.get(path));
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < read.size(); i++) {
            String[] temp = read.get(i).split(",");
            map.put(temp[1], temp[3]);
        }
        return map;
    }
}
