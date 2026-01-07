package br.com.webautomationselenium.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.webautomationselenium.global.Constants;

/**
 * Utility class responsible for browser-related base operations,
 * such as screenshots and report file management.
 */
public class Utils {

    /**
     * Moves the generated HTML report file to a specific directory.
     * If the directory already exists, it will be cleaned before moving the file.
     *
     * @param targetPath Destination directory
     * @param routineDescription Routine description used for organization
     * @throws IOException In case of I/O failure
     */
    public void moveHtmlReportToDirectory(
            String targetPath,
            String routineDescription) throws IOException {

        File directory = new File(targetPath);

        if (!directory.exists()) {
            directory.mkdirs();
        } else {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }

        Path source = Paths.get(Constants.REPORTS_SOURCE_PATH);
        Path destination = Paths.get(targetPath);
        String extension = ".html";

        if (Files.notExists(destination)) {
            Files.createDirectory(destination);
        }

        try (Stream<Path> files = Files.list(source)) {
            List<Path> reportFiles = files
                    .filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(extension))
                    .collect(Collectors.toList());

            for (Path file : reportFiles) {
                Files.move(file, destination.resolve(file.getFileName()));
            }
        }
    }

    /**
     * Returns the HTML report file name with a formatted timestamp.
     *
     * @return Report file name
     */
    public static String getHtmlReportName() {
        return Constants.REPORT_BASE_NAME
                + DateUtils.getCurrentDateTimeFormatted()
                + ".html";
    }
}