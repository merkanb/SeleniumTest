package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("Hello World");

        //2 - getAttribute() --> second way of getting text especially input box
        Thread.sleep(2000);        // we need this time for synchronization issue
        System.out.println("emailInput.getText() = " + emailInput.getText());      // emailInput.getText() =  // do not get "Hello World" entry.
        System.out.println("Email Area = " + emailInput.getAttribute("value"));    // Email Area = Hello World

        System.out.println("emailInput.getAttribute(\"id\") = " + emailInput.getAttribute("id"));
        System.out.println("emailInput.getAttribute(\"placeholder\") = " + emailInput.getAttribute("placeholder"));
        System.out.println("emailInput.getAttribute(\"name\") = " + emailInput.getAttribute("name"));
        System.out.println("emailInput.getAttribute(\"type\") = " + emailInput.getAttribute("type"));
        driver.close();

    }
}
