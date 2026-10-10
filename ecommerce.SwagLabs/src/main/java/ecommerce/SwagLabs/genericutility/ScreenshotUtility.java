package ecommerce.SwagLabs.genericutility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String takeScreenshot(
            WebDriver driver,
            String testName,
            String status) {

        try {

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            // Get the current project execution location
            String projectPath = System.getProperty("user.dir");

            // Create screenshots folder inside project
            String folderPath = projectPath + File.separator + "screenshots";

            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String cleanTestName =
                    testName.replaceAll("[^a-zA-Z0-9_-]", "_");

            String fileName =
                    cleanTestName
                    + "_"
                    + status
                    + "_"
                    + timeStamp
                    + ".png";

            File destination = new File(folder, fileName);

            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("======================================");
            System.out.println("Screenshot captured successfully");
            System.out.println("Test Name : " + testName);
            System.out.println("Status    : " + status);
            System.out.println("Full Path : " + destination.getAbsolutePath());
            System.out.println("======================================");

            return destination.getAbsolutePath();

        } catch (Exception e) {

            System.out.println("Screenshot capture failed!");
            e.printStackTrace();

            return null;
        }
    }
}