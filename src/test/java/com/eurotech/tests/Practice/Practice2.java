package com.eurotech.tests.Practice;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Practice2 {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.get("https://learn.canvas.net/login/canvas%22");
        driver.get("https://canvas.instructure.com/login/canvas");

        WebDriverWait wait = new WebDriverWait(driver, 2); // Wait for up to 10 seconds  ???
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='email address']")));

        driver.findElement(By.cssSelector("#pseudonym_session_unique_id")).sendKeys("Merallondon@live.co.uk");
        driver.findElement(By.cssSelector("#pseudonym_session_password")).sendKeys("Meral");
        driver.findElement(By.xpath("//button[@class='Button Button--login']")).click();
//        driver.findElement(By.id("password")).sendKeys("Meral");
//        driver.findElement(By.name("submitBtn")).click();



        driver.quit();
    }

}
