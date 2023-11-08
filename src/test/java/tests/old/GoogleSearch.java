package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.DriverSetup;

public class GoogleSearch extends DriverSetup {


    @Test
    public void searchForDucks() {

        driver.get("https://www.google.com/");


        WebElement acceptAllButton = driver.findElement(By.xpath("//div[contains(.,'Alle akzeptieren')]"));

        acceptAllButton.click();

    }

}
