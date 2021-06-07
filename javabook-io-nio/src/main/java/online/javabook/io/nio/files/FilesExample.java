package online.javabook.io.nio.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Java NIO Files类（java.nio.file.Files）提供了几种在文件系统中操作文件的方法
 */
public class FilesExample {
    public static void main(String[] args) throws IOException {

        // --------------------------------------------------------------------------
        // Files.exists()
        // --------------------------------------------------------------------------
        Path path = Paths.get("./javabook-io-nio/testdata");

        // Do not follow symbolic links.
        boolean pathExists = Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        System.out.println("pathExists:" + pathExists);

        // --------------------------------------------------------------------------
        // Files.createDirectory()
        // --------------------------------------------------------------------------
        Path path2 = Paths.get("./javabook-io-nio/testdata");
        try {
            Path newDir = Files.createDirectory(path2);
        } catch (FileAlreadyExistsException e) {
            // the directory already exists.
            //e.printStackTrace();
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }

        // --------------------------------------------------------------------------
        // Files.copy()
        // --------------------------------------------------------------------------
        Path sourcePath = Paths.get("./javabook-io-nio/testdata/copysource.txt");
        Path targetPath = Paths.get("./javabook-io-nio/testdata/copytarget.txt");

        try {
            Files.copy(sourcePath, targetPath);
            //Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileAlreadyExistsException e) {
            //destination file already exists
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }

        // --------------------------------------------------------------------------
        // Files.move()
        // --------------------------------------------------------------------------
        Path moveSourcePath = Paths.get("./javabook-io-nio/testdata/movesource.txt");
        Path moveTargetPath = Paths.get("./javabook-io-nio/testdata/subdir/movesource.txt");

        try {
            Files.move(moveSourcePath, moveTargetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            //moving file failed.
            //e.printStackTrace();
        }

        // --------------------------------------------------------------------------
        // Files.move()
        // --------------------------------------------------------------------------
        Path deletePath = Paths.get("./javabook-io-nio/testdata/delete.txt");

        try {
            Files.delete(path);
        } catch (IOException e) {
            //deleting file failed
            //e.printStackTrace();
        }

        // --------------------------------------------------------------------------
        // Files.walkFileTree()
        // FileVisitResult.CONTINUE
        // FileVisitResult.TERMINATE
        // FileVisitResult.SKIP_SIBLINGS
        // FileVisitResult.SKIP_SUBTREE
        // --------------------------------------------------------------------------
        Path walkPath = Paths.get("./javabook-io-nio/testdata");
        Files.walkFileTree(walkPath, new FileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("pre visit dir:" + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visit file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("post visit directory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });

        // --------------------------------------------------------------------------
        // Searching For Files
        // --------------------------------------------------------------------------
        String fileToFind = File.separator + "search.txt";

        try {
            Files.walkFileTree(walkPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    if(fileString.endsWith(fileToFind)){
                        System.out.println("file found at path: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }

        // --------------------------------------------------------------------------
        // Deleting Directories Recursively
        // --------------------------------------------------------------------------

        /*try {
            Files.walkFileTree(walkPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("delete file: " + file.toString());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    System.out.println("delete dir: " + dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch(IOException e){
            e.printStackTrace();
        }*/
    }
}
