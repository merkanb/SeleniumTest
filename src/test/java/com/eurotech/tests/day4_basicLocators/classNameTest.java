package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class classNameTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(1000);

        System.out.println("driver.findElement(By.className(\"my-2\")).getText() = " + driver.findElement(By.className("my-2")).getText());

        driver.close();

        driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("Test123");
        // it will not work because there is a space in class Name value...


        Thread.sleep(1000);
        driver.close();


    }
}
