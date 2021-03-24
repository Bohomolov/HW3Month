package iostreams.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IoFileReader {
    private final FileComparator fileComparator = new FileComparator();
    private final String pathName = "src/main/java/iostreams/container/";

    public List<String> readFile(File file) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public List<File> readAllFileFromDirectory() {
        File[] fileArray = new File(pathName).listFiles();
        List<File> files = null;
        if (fileArray != null) {
            files = Arrays.stream(fileArray).sorted(fileComparator).collect(Collectors.toList());
        }
        return files;
    }
}
