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

public class Homework {
    // navigate to "https://demoqa.com/elements"    //         Elements list - verify the size =9
//        assert every option is displayed on the page      //        print out all the options

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/elements");
        List<WebElement> itemlist = driver.findElements(By.xpath("//span[text()='Text Box']/../..//span"));

        int expectedSize = 9;
        int actualSize = itemlist.size();
        //verify the total number of itemlist elements
        Assert.assertEquals(actualSize, expectedSize, "Verifying there are " + expectedSize + "items");


        System.out.println(driver.findElement(By.xpath("//span[text()='Text Box']/../..//span[1]")).getText());
        System.out.println(".....");
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Text Box']/../..//span[1]")).isDisplayed(), "First item is NOT displayed");


        // assert every option is displayed on the page
        for (WebElement item : itemlist) {
            Assert.assertTrue(item.isDisplayed(), "Verifying all items are DISPLAYED");
        }

        // print all the options
        for (WebElement item : itemlist) {
            System.out.println(item.getText());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}