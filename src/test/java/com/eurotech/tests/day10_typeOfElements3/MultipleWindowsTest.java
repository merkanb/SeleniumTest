package com.eurotech.tests.day10_typeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    // get title    // Click "Click Here" link    // get title of the new window
    @Test
    public void twoWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        driver.findElement(By.linkText("Click Here")).click();      // button which is a actually a link has text, open a new tab
        String initialWindowId = driver.getWindowHandle();        // we clicked but still on the initial tab not switched yet..
        System.out.println("initialWindowId = " + initialWindowId);

        Set<String> windowHandles = driver.getWindowHandles();      // getWindowHandles() returns the windows id a list
        for (String handle : windowHandles) {
            if (!handle.equals(initialWindowId)) {       // ! which one not be the current tab, means find the other, new opened tab...
                driver.switchTo().window(handle);       // will be second/new one
            }
        }

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowID = driver.getWindowHandle();// get the current window ID

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        clickHere.click();          // open 2nd new, will be total 3 tab...

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("New Window")) {            // this expected title already known or provided...
                System.out.println("Title = " + driver.getTitle());
                break;
            }
        }
// go back to initial window
        driver.switchTo().window(parentWindowID);
        System.out.println("Title = " + driver.getTitle());

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
