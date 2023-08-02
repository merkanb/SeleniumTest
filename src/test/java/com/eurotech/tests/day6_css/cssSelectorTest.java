package com.eurotech.tests.day6_css;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cssSelectorTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         Setup browser   navigate to the "http://eurotech.study/login"
         locate email, passwrod, login button, confirm cookies button with CSS
         enter email, password and login
         close the browser      eurotech@gmail.com          Test12345!
         **/

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.cssSelector("button#rcc-confirm-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#loginpage-input-email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test12345!");
        driver.findElement(By.cssSelector("input.btn,btn-primary")).click();
        Thread.sleep(1000);
        driver.close();


    }
}
