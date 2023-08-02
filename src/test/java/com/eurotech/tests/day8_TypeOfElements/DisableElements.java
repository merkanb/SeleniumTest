package com.eurotech.tests.day8_TypeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {
    /*
            --navigate https://the-internet.herokuapp.com/dynamic_controls
            --verify that inputbox element is disabled
            --click enable button
            --verify that  inputbox element is enabled
             */

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));  //2.path: //input[@type='text']
        Assert.assertFalse(inputBox.isEnabled(), "inputBox is ENABLED");
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();   //2.path:  #input-example>button
        Thread.sleep(3000);
        Assert.assertTrue(inputBox.isEnabled(), "InputBox is DISABLED");
        inputBox.sendKeys("Euro-tech was here");

        Thread.sleep(1000);
        driver.close();
    }
}
