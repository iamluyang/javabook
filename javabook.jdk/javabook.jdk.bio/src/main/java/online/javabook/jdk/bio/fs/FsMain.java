package online.javabook.jdk.bio.fs;

import java.nio.file.FileSystem;
import java.util.ServiceLoader;

public class FsMain {
    public static void main(String[] args) {
        ServiceLoader<FileSystem> serviceLoader = ServiceLoader.loadInstalled(FileSystem.class);
        FileSystem fileSystem = serviceLoader.iterator().next();
        System.out.println(fileSystem);
   }
}
