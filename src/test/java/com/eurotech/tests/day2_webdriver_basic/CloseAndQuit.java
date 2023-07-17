package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        driver.close();             // close current tab (window)

//        driver = new ChromeDriver();   //browser allready closed, need to open new one  //Exception: NoSuchSessionException: invalid session id
        driver.get("https://www.google.com");            // get error in this line // (CloseAndQuit.java:17)
        Thread.sleep(2000);
        driver.quit();              //  close all browsers
    }
}
