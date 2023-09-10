package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicWebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dynamic1() {
    driver.get("https://demoqa.com/webtables");
        System.out.println(driver.findElement(By.xpath("//*[text()='kierra@example.com']/../div[1]")).getText());
        driver.findElement(By.xpath("//*[text()='Last Name']")).click();
        System.out.println(driver.findElement(By.xpath("//*[text()='kierra@example.com']/../div[1]")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//*[text()='kierra@example.com']/../div[1]")).getText(), "Kierra");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
