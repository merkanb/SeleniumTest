package com.eurotech.tests.day12_action_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clickWithJS() {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        WebElement china = driver.findElement(By.linkText("China"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", china);

    }

    @Test
    public void typeWithJS() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox=driver.findElement(By.xpath("//input[@type='text']"));
        String text="Hello Disabled Input";
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')",inputBox);
        jse.executeScript("arguments[0].setAttribute('value','Hey how do you do')",inputBox);

    }

    @Test
    public void scrollUpAndScrollDown() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        Thread.sleep(2000);
//        jse.executeScript("window.scrollBy(0,500)");
//        Thread.sleep(2000);
        for (int i = 0; i < 10; i++) {
             Thread.sleep(1000);
             jse.executeScript("window.scrollBy(0,250)");
        }

        for (int i=0; i<10; i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement spain=driver.findElement(By.linkText("Spain"));

        jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.linkText("Spain")));
//        jse.executeScript("arguments[0].scrollIntoView(true);",spain);
        jse.executeScript("arguments[0].click();",driver.findElement(By.linkText("Spain")));
//        jse.executeScript("arguments[0].click();",spain);
        Thread.sleep(2000);





    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
