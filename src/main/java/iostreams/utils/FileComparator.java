package iostreams.utils;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File> {
    @Override
    public int compare(File o1, File o2) {
        int firstFile = Integer.parseInt(o1.getName().substring(o1.getName().lastIndexOf("№") + 1, o1.getName().lastIndexOf(".")));
        int secondFile = Integer.parseInt(o2.getName().substring(o2.getName().lastIndexOf("№") + 1, o2.getName().lastIndexOf(".")));
        return firstFile - secondFile;
    }
}

