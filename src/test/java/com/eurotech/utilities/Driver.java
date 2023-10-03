package com.eurotech.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {               // this Driver class is a sample of Singleton Pattern/Design ....
    // by this feature, from everywhere outside this class, we can able to create only 1 instance (WebDriver) of this Driver class
    private Driver(){
        // encapsulated Constructor, can not reach from outside, can not create object from outside..
        // the only 1 way to instantiation is by from this Driver class, get() static method...
    }

    private static WebDriver driver;
    // this Driver class is JUST FOR restrict the creating of this WebDriver driver instance more than 1 ...

    public static WebDriver get(){         // here WebDriver is return type    so will return   driver object !!!!
        //this method run multiple times by outside test methods, but all get/run over only 1 driver/browser
        if(driver == null){
            String browser = ConfigurationReader.get("browser");
            switch(browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\DERS NOTLARI\\4 AUTOMATION\\selenium grid\\chromedriver.exe");
// because of the need to run latest version of chrome for cross browser running, we give this latest chromedriver.exe path to here to system Property..
                    driver = new ChromeDriver();
                    break;

                case "chrome-headless":
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "firefox-headless":
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    driver = new SafariDriver();
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
