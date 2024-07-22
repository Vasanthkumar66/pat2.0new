package utilities;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static void deleteFilesInFolder(String folderPath) throws IOException {
        Path directory = Paths.get(folderPath);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                Files.delete(path);
            }
        }
    }
    
    public static void renamethefile(String newFilename,String downloadpath) throws IOException {
        File dir = new File(downloadpath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".xlsx")); // Adjust the extension as needed

        assertTrue(files != null && files.length == 1); // Ensure only one file is downloaded

        File downloadedFile = files[0];
        Path source = Paths.get(downloadedFile.getAbsolutePath());
        Path target = Paths.get(downloadpath, newFilename);
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}