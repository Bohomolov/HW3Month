package iostreams.controller;

import iostreams.utils.FileCreator;
import iostreams.utils.IoFileReader;

import java.io.*;
import java.util.List;

public class Controller {
    private final FileCreator fileCreator = new FileCreator();
    private final IoFileReader fileReader = new IoFileReader();
    private final String pathName = "src/main/java/iostreams/Box.txt";

    public void execute(boolean firstMode, boolean secondMode) {
        fileCreator.createFiles();
        List<File> files = fileReader.readAllFileFromDirectory();
        File fileBox = new File(pathName);
        List<String> strings = fileReader.readFile(fileBox);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileBox, firstMode))) {
            for (File f : files) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
                    while (bufferedReader.ready()) {
                        bufferedWriter.write(bufferedReader.readLine());
                        bufferedWriter.newLine();
                    }
                }
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (secondMode) {
            addDataToStartFile(strings, fileBox);
        }
    }


    private void addDataToStartFile(List<String> strings, File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
