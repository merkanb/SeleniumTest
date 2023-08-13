package com.eurotech.tests.day10_typeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);
        // switch into iframe by id
        //  driver.switchTo().frame(XXX);    //   there are 3 options to switch a frame/iframe
        driver.switchTo().frame("mce_0_ifr");           //1. way: provide iframe ID value
        WebElement textArea=driver.findElement(By.id("tinymce"));       // textArea  WE

        textArea.clear();
        textArea.sendKeys("Euro-tech is here");

        // switching the parent frame
        driver.switchTo().parentFrame();

        // switch into iframe by index   (starts with 0)
        // switch to [0] index iframe inside parentFrame which was only 1 already
        driver.switchTo().frame(0);     // 2.way:  with index, starts with 0
        textArea.clear();
        textArea.sendKeys("Euro-tech is here for the second time");
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        // switch into iframe using WE
        WebElement iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iframe);                // 3.way:   with providing WE
        textArea.clear();
        textArea.sendKeys("Euro-tech is here for the third time");
        Thread.sleep(1000);
    }

    @Test
    public void nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middleText = driver.findElement(By.cssSelector("#content"));
        System.out.println("middleText = " + middleText.getText());

//        driver.switchTo().parentFrame();            // 1. way
//        driver.switchTo().frame("frame-top");       // 2. way


        driver.switchTo().defaultContent();         // same as like navigated url first time
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println("leftText = " + leftText.getText());

        // task   print out "BOTTOM" text
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomText = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println("bottomText = " + bottomText.getText());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
