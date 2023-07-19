package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tagNameExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        driver.findElement(By.tagName("input")).sendKeys("Teacher");
        //Selenium starts looking for the element from first line
        //After finds the element, it clicks or writes etc
        ///Then selenium go back first line again and starts looking for from there.

        driver.findElement(By.tagName("input")).sendKeys("eurotech@gmail.com");

        Thread.sleep(1000);
        driver.close();






    }
}
