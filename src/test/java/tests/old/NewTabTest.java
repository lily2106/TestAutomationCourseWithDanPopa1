package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Set;

public class NewTabTest {

    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tabTests(){
        driver.get("https://qa-practice.netlify.app/tab");

        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        //Check if we have only one tab opened
        System.out.println(driver.getWindowHandles().size());
        Assert.assertEquals(driver.getWindowHandles().size(), 1);

        WebElement newTabButton = driver.findElement(By.id("newTabBtn"));

        newTabButton.click();

        //Check if we have only one tab opened
        System.out.println(driver.getWindowHandles().size());
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        Action action = new Actions(driver);
        action.keyDown(Keys.CONTROL).keyDown(Keys.TAB).build().perform();

        WebElement secondTabTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
        System.out.println(secondTabTitle.getText());
        Assert.assertEquals(secondTabTitle.getText(), "Table Example");



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
