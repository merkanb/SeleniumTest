package com.eurotech.tests.day15_POM1;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {



    @Test
    public void test() {
        driver.get(ConfigurationReader.get("url"));


        WebElement userInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        wait.until(ExpectedConditions.elementToBeClickable(understandBtn));
        understandBtn.click();

        userInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginBtn.click();




    }


}