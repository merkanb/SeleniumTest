package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.xpath("//button[@id='ez-accept-necessary']")).click();
        WebElement tableTitle = driver.findElement(By.xpath("//span[text()='Demo Webtable 2 (Dynamic Table)']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",tableTitle);    // scroll to the WE
    }


    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println("table.getText() = " + table.getText());     // get the whole table text
    }



}
