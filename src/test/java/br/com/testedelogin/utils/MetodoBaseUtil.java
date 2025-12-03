package br.com.testedelogin.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import br.com.testedelogin.global.Constants;

/**
 * Utility class responsible for browser-related base operations,
 * such as screenshots and report file management.
 */
public class MetodoBaseUtil {

    protected final WebDriver driver;

    /**
     * Constructor.
     *
     * @param driver WebDriver instance
     */
    public MetodoBaseUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Takes a screenshot and saves it in the default screenshot folder.
     *
     * @param testDescription Description used to name the screenshot file
     * @return Absolute path of the saved screenshot
     */
    public String takeScreenshot(String testDescription) {
        File destinationFile = new File(
                Constants.SCREENSHOT_FOLDER_PATH + testDescription + ".png");

        File sourceFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Error while saving screenshot", e);
        }

        return destinationFile.getAbsolutePath();
    }

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