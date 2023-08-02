package com.eurotech.tests.day8_TypeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
     /*
            --navigate https://rahulshettyacademy.com/AutomationPractice/
            --Verify that radio button 2 is unselected
            --Click radio button 2
            --verify that radio button 2 is selected
             */

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement Radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));
        Assert.assertFalse(Radio2.isSelected(), "Radio2 is SELECTED");
        Radio2.click();
        Assert.assertTrue(Radio2.isSelected(), "Radio2 is UNSELECTED");

//        -Click radio button 3
//         --verify that radio button 3 is selected
//        and radio button 2 is unselected

        WebElement Radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
        Radio3.click();
        Assert.assertTrue(Radio3.isSelected(), "Radio3 in UNSELECTED");
        Assert.assertFalse(Radio2.isSelected(), "Radio2 is SELECTED");

        Thread.sleep(1000);
        driver.close();

    }
}
