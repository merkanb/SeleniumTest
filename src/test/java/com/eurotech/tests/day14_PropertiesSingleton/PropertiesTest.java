package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test() throws InterruptedException {
// WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

// driver.get("http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("rcc-confirm-button")).click();

//        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("email")).sendKeys(ConfigurationReader.get("usernameTeacher"));

//        driver.findElement(By.name("password")).sendKeys("Test12345!");
//        driver.findElement(By.id("loginpage-form-btn")).click();
        driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER);
        // ENUM Keys from Selenium contains keyboard KEYS commands !!!!  + Keys.ENTER - so no need to click, two in one shot

        Thread.sleep(1000);

        driver.close();



    }
}