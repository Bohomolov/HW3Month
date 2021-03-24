package iostreams.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    private final String pathName = "src/main/java/iostreams/container/File№%s.txt";
    private final String firstData = "Some data + i; i = %s;\n";
    private final String secondData = "Some one more data + i; i = %s";

    public void createFiles() {
        for (int i = 1; i <= Byte.MAX_VALUE; i++) {
            File file = new File(String.format(pathName, i));
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(String.format(firstData, i));
                bufferedWriter.write(String.format(secondData, i));
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
