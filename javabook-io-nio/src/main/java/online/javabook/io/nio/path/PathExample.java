package online.javabook.io.nio.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java Path接口是Java NIO 2更新的一部分，Java NIO在Java 6和Java 7中收到了该Path接口。
 * Java接口已添加到Java 7中的Java NIO中。该Path接口位于java.nio.file包中，因此Java的全限定名Path介面是java.nio.file.Path。
 *
 * Java Path实例表示文件系统中的路径。路径可以指向文件或目录。路径可以是绝对路径，也可以是相对路径。
 * 绝对路径包含从文件系统根目录到其指向的文件或目录的完整路径。相对路径包含相对于其他路径的文件或目录路径。相对路径可能听起来有些混乱。
 */
public class PathExample {
    public static void main(String[] args) {
        // Creating a Path Instance
        Path path = Paths.get("./javabook-io-nio/testdata");
        boolean pathExists = Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        System.out.println("pathExists:" + pathExists);

        // 相对路径
        Path relativePath = Paths.get("./javabook-io-nio/testdata", "subdir2");
        boolean relativePathExists = Files.exists(relativePath, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        System.out.println("relativePath:" + relativePathExists);
        System.out.println();

        // 当前路径
        Path currentPath = Paths.get(".");
        System.out.println("currentPath:"+currentPath.toAbsolutePath());

        Path parentPath = Paths.get("..");
        System.out.println("parentPath:"+parentPath.toAbsolutePath());
        System.out.println();

        // 路径的相对关系
        Path basePath = Paths.get("./javabook-io-nio/testdata");
        Path childPath = Paths.get("./javabook-io-nio/testdata/subdir");

        Path basePathToPath = basePath.relativize(childPath);
        System.out.println(basePath + ">cd " + basePathToPath);

        Path pathToBasePath = childPath.relativize(basePath);
        System.out.println(childPath + ">cd " + pathToBasePath);
        System.out.println();

        // 路径的归一化：计算路径中的..或。
        Path originalPath = Paths.get("./javabook-io-nio/testdata/..");
        Path normalizePath = originalPath.normalize();

        System.out.println("originalPath:" + originalPath);
        System.out.println("normalizePath:" + normalizePath);
    }
}
