package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverTests {

 /*   @Test
    public void test1() throws InterruptedException {
         1st way
        WebDriver driver = WebDriverFactory.getDriver("chrome");
         2nd way
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        3rd way
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));  // navigate to URL --> driver.get() in it ConfigurationReader.get() static method
        Thread.sleep(1000);
        Driver.closeDriver();
    }
     */

    @Test
    public void test2() throws InterruptedException {
//        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();

        driver.get("https://www.amazon.com/"); // we may use --> ConfigurationReader.get("url") it this URL defined in "configuration.properties"

        Thread.sleep(1000);
    }

    @Test
    public void test3() throws InterruptedException {
//        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();

        driver.get("https://en-gb.facebook.com/");

        Thread.sleep(1000);
    }

    // NOTE:  WE did not close the driver, and both tests run in same driver   (Singleton model/pattern)
}
