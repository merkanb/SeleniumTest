package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xpath_Task {
    public static void main(String[] args) throws InterruptedException {
          /*
            Test Case 2      go to ebay.com  search selenium   click on search button    print number of results
           */
        //USE XPATH LOCATOR ONLY

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
        String resultText = driver.findElement(By.xpath("//span[text()='selenium']")).getText();
        System.out.println("resultText = " + resultText);

//        String text = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
//        text = text.replaceAll("[^0-9 ]", "");
//        System.out.println(text);             // this 3 lines may be 2.way instead of previous 2 lines


        Thread.sleep(1000);
        driver.close();


    }
}
