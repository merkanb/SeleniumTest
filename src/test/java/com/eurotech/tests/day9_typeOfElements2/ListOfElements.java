package com.eurotech.tests.day9_typeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void testName() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> listitems = driver.findElements(By.xpath("//a[text()='A/B Testing']/../..//a"));  // findElements()  "s"
        int expectedSize=44;
        int actualSize=listitems.size();
        //verify the total number list items
        Assert.assertEquals(actualSize,expectedSize,"Verifying there are " +expectedSize+ " items");

        // print all the items in the list
        for (WebElement listitem : listitems) {
            System.out.println(listitem.getText());
        }

         // iterate over list items and click the "Checkboxes"
        String itemToClick="Checkboxes";
        for (WebElement listitem : listitems) {
           if (listitem.getText().equals(itemToClick)){
               System.out.println("item to click " +itemToClick+ "is found, will click");
               listitem.click();
               Thread.sleep(2000);
               break;
           }
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
