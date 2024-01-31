package com.eurotech.tests.day2_webdriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
         /*
        TC        navigates to http://eurotech.study/login        verify that title is DevEx
         */

        WebDriver driver= WebDriverFactory.getDriver("chRomE");
        driver.get("http://www.eurotech.study/login");


        String expecteTitle="DevEx";
        String actualTitle=driver.getTitle();

        if (expecteTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
