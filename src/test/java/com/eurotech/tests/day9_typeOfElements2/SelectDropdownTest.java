package com.eurotech.tests.day9_typeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));  // locating WE of which tag is <select : Dropdown ...
        Select select=new Select(colorDropdown);     // Select class, provide WE (Dropdown), so select object will be able to use following select methods,
        // if there is select tag in HTML - hopefully

        int expecteSize=11;
        System.out.println(select.getOptions().get(0).getText());      // first element`s text   // select.getOptions() return --> List object ..
        System.out.println(",,,,,,");

        List<WebElement> options = select.getOptions();
        int actualSize=options.size();
        Assert.assertEquals(actualSize,expecteSize,"Verifying there are "+expecteSize+ " is the color Dropdown");

        // print out all the options
        for (WebElement option : options) {         // each element is a WE, 1by1 getText() and print..
            System.out.println(option.getText());
        }

        // verify the initial/default/firsSelected color is "Red"  // getFirstSelectedOption() --> return selected option which get TOP PLACE ..
        String expectedSelectedColor="Red";
        String actualSelectedColor=select.getFirstSelectedOption().getText();   // getFirstSelectedOption()  method
        Assert.assertEquals(actualSelectedColor,expectedSelectedColor,"Verifying first selected color is Red");

        // Select Yellow by visibleText and verify it has been selected
        select.selectByVisibleText("Yellow");               // selectByVisibleText()
        Thread.sleep(1000);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("Yellow"),"Verifying that the selected color is Yellow");

        // Select Green by index and verify it has been selected
        select.selectByIndex(2);                             // selectByIndex()  // here index starts from 0
        Thread.sleep(1000);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("Green"),"Verifing that the selected color is Green");

        // Select Indigo by selectByValue and verify it has been selected
        select.selectByValue("8");
        Thread.sleep(1000);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("Indigo"), "Verifying that the selected color is Indigo");

        select.selectByValue("red");
        Thread.sleep(1000);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("Red"), "Verifying that the selected color is Red");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
