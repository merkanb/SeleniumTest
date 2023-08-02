package com.eurotech.tests.day8_TypeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
/*
            --Navigate https://rahulshettyacademy.com/AutomationPractice/
            --verify that option1 is unselected
            --Click option1
            ==verify that option1 is selected
            --Click option2
            --verify that option2 is selected
            --verify that option3 is unselected
             */

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement option1 = driver.findElement(By.cssSelector("#checkBoxOption1"));     // 2.path:  //input[@value='option1']
        Assert.assertFalse(option1.isSelected(),"Option1 is SELECTED");
        option1.click();
        Thread.sleep(4000);
        Assert.assertTrue(option1.isSelected(),"Option1 is UNSELECTED");
        driver.findElement(By.xpath("//input[@value='option2']")).click();  // 2.path:     #checkBoxOption2
        WebElement option2 = driver.findElement(By.cssSelector("#checkBoxOption2"));
        Assert.assertTrue(option2.isSelected(),"Option2 is UNSELECTED");
        WebElement option3 = driver.findElement(By.xpath("//input[@value='option3']"));
        Assert.assertFalse(option3.isSelected(),"Option3 is SELECTED");

        Thread.sleep(1000);
        driver.close();

    }
}
