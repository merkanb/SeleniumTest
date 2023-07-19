package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task {
    public static void main(String[] args) throws InterruptedException {


          /*
          HomeWork
        --open the chrome browser
        --navigate the "http://eurotech.study/login"
        --enter email address "eurotech@gmail.com"
        --enter password "Test12345!"
        --Click login button
        --verify that dashboard text is visible
         */

        String expectedDashboardText="Dashboard";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(1000);
        String actualDashbordText = driver.findElement(By.id("dashboard-h1")).getText();

        if (expectedDashboardText.equals(actualDashbordText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(1000);
        driver.close();
    }
}
