package com.eurotech.tests.day8_TypeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class DisabledDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//verify that Hello World! is not visible, there is an element but is not visible,
        WebElement HelloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertFalse(HelloWorld.isDisplayed(), "Hello World is DISPLAYED");
//click start button
        driver.findElement(By.xpath("//div[@id='start']/button")).click();  // 2.path:    //button[text()='Start']
        Thread.sleep(5000);

        //verify that Hello World! is visible (displayed)
        System.out.println("HelloWorld.getText() = " + HelloWorld.getText());
        Assert.assertTrue(HelloWorld.isDisplayed(),"Hello World is NOT DISPLAYED");
        Thread.sleep(1000);
        driver.close();
    }


    @Test
    public void test2() throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        /* verify that Hello World! is not visible
     Here in this page, "Hello World" text is rendered after clicking the "Start Button",
     so it was not available neither in the html nor it was displayed initially.
     That is why is throwing "NoSuchElementException" when you try to locate it */

        //        WebElement HelloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
//        Assert.assertFalse(HelloWorld.isDisplayed(), "HelloWorld is DISPLAYED");


        driver.findElement(By.xpath("//button[text()='Start']")).click();  //2. way  -->  //div[@id='start']/button

        Thread.sleep(5000);

// after clicking Start button now it is possible to locate  Hello World!  and apply getText()

        WebElement HelloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(HelloWorld.isDisplayed(), "HelloWorld is NOT DISPLAYED");

        //verify that Hello World! is visible (displayed)

        System.out.println("HelloWorld.getText() = " + HelloWorld.getText());    // HelloWorld.getText() = Hello World!


        Thread.sleep(1000);
        driver.close();

    }
}

