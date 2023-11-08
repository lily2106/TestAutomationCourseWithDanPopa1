package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.DriverSetup;

public class BasicSeleniumTest extends DriverSetup {

    @Test
    @Parameters({"website title", "second title"})
    public void sampleTest(String title, String secondTitle) {
        driver.get("https://www.example.com/");
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        Assert.assertEquals(pageTitle, title);

        WebElement linkText = driver.findElement(By.linkText("More information..."));

        linkText.click();

 //       WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement textInsideSecondPage = driver.findElement(By.xpath("//h2[contains(.,'Further Reading')]"));

        Assert.assertEquals(textInsideSecondPage.getText(), secondTitle);
    }
}
