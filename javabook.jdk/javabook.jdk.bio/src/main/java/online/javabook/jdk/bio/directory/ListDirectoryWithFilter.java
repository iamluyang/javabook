package online.javabook.jdk.bio.directory;

import java.io.File;
import java.io.FilenameFilter;

public class ListDirectoryWithFilter {
    public static void main(String[] args) {

        File dir = new File(".");

        if (dir.isDirectory()) {
            String[] files = dir.list(new FilenameFilter() {
                public boolean accept(File dir, String file) {
                    return file.endsWith(".xml");
                }
            });

            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}