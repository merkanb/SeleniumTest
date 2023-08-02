package com.eurotech.tests.day8_TypeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework {
    /*
        --navigate https://demo.aspnetawesome.com/
        --verify that vegetable is selected
        --verify that legume is NOT SELECTED
        --click legume
        --Verify that vegetable is NOT SELECTED
         --verify that legume is selected
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        WebElement VegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
        Assert.assertTrue(VegetablesRadio.isSelected(),"VegetablesRadio is NOT SELECTED");
        WebElement LegumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        Assert.assertFalse(LegumesRadio.isSelected(),"LegumesRadio is SELECTED");
        WebElement Legumes = driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]"));
        Legumes.click();
        Thread.sleep(1000);
        Assert.assertFalse(VegetablesRadio.isSelected(),"VegetablesRadio is SELECTED");
        Assert.assertTrue(LegumesRadio.isSelected(),"LegumesRadio is NOT SELECTED");




    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
