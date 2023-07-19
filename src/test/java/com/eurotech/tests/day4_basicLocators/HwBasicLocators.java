package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HwBasicLocators {
    public static void main(String[] args) throws InterruptedException {
          /*
        --open chrome browser        --navigate ebay.com        --search selenium        --verify that result area has selenium text
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("gh-ac")).sendKeys("selenium");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(1000);
        String text = driver.findElement(By.className("srp-controls__count-heading")).getText();

        if (text.contains("selenium")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        Thread.sleep(1000);
        driver.close();


    }
}
