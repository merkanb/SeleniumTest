package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xpathLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.xpath("//input[@id='loginpage-input-email']")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test12345!");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//p[@id='dashboard-p1']")).getText());
        String text = driver.findElement(By.xpath("//a[text()=' DevEx']")).getText();
        System.out.println("text = " + text);
        Thread.sleep(1000);
        driver.close();


    }
}
