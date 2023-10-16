package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // implictly wait works with findElement(), works till WE located, set once use whenever it needs (in all methods)
    }
    //Navigate https://the-internet.herokuapp.com/dynamic_loading/1
    //Click start button
    //Verify that Hello World! text

    @Test
    public void explicitWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();
//        driver.findElement(By.xpath("//*[text()='Start']")).click();            //2. locator

        WebElement helloWorldText = driver.findElement(By.cssSelector("#finish>h4"));
//        WebElement helloWorldText = driver.findElement(By.xpath("//*[text()='Hello World!']"));    //2. locator

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10) );      //create explicit wait object (provide driver and time)
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));    // explicit wait according to the condition..

        Assert.assertEquals(helloWorldText.getText(), "Hello World!", "Text is NOT matched");
        System.out.println("Text = " + helloWorldText.getText());
    }

    @Test
    public void explicitWait2() {
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableBtn = driver.findElement(By.cssSelector("#input-example>button"));
        enableBtn.click();

        WebElement inputArea = driver.findElement(By.cssSelector("#input-example>input"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));           //create explicit wait object
        wait.until(ExpectedConditions.elementToBeClickable(inputArea));   // explicit wait according to the condition.. !!!
        inputArea.sendKeys("Euro-tech was here");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
