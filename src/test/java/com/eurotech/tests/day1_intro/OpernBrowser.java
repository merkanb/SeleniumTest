package com.eurotech.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class OpernBrowser {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hepsiburada.com");
        Thread.sleep(3000);
        driver.close();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1=new FirefoxDriver();
        driver1.get("https://www.akakce.com");
        Thread.sleep(2000);
        driver1.close();



    }
}
