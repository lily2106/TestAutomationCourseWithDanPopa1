package utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {this.driver = driver;}

    public void captureAndSaveScreenshot(String testName) {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotFileName = testName + "_" + timeStamp + ".png";
        String screenshotDirectory = "screenshots"; // Specify your desired directory

        File targetFile = new File(screenshotDirectory, screenshotFileName);
        FileUtils.copyFile(screenshotFile, targetFile);
        System.out.println("Screenshot saved to " + targetFile.getAbsolutePath());

        }
 //       catch (IOException io) {
 //           io.printStackTrace();
 //       }

    }

}
