package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IdLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        Faker faker=new Faker();
        driver.findElement(By.id("userName")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("userName")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("currentAddress")).click();


        Thread.sleep(1000);
        driver.close();




    }
}
