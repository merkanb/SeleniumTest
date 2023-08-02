package com.eurotech.tests.day9_typeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        WebElement dropdown = driver.findElement(By.xpath("(//div[@class='o-slbtn'])[8]"));  // dropdown arrow
        WebElement firstSelectedOption = driver.findElement(By.xpath("(//div[@class='o-cptn'])[8]"));
        Assert.assertEquals(firstSelectedOption.getText(), "Mango", "Verifying Mango is the selected option");
        dropdown.click();
        List<WebElement> dropDownList = dropdown.findElements(By.xpath("(//ul[@class='o-mnits'])[8]/li"));
        System.out.println("Number of the options = " + dropDownList.size());
        Assert.assertEquals(dropDownList.size(),25, "Verifying that size of the list is 25");
        for (WebElement fruit : dropDownList) {
            System.out.println(fruit.getText());
        }

        String expectedFruit="Banana";
        String actualFruit=dropDownList.get(3).getText();
        Assert.assertEquals(actualFruit,expectedFruit,"Verifying 4th option is Banana");

        dropDownList.get(3).click();
        Assert.assertEquals(firstSelectedOption.getText(), "Banana", "Verifying Banana is the selected option");

// alternatively we can loop (for each) through the dropDownList and get the text of each item .. and matches with asked one, click it...
//        for (WebElement option : dropDownList) {
//            if (option.getText().equals("Banana")){
//                option.click();
//                break;
//            }
//        }


//        dropDownList.get(4).click();
//        System.out.println("dropDownList.get(4).getText() = " + dropDownList.get(4).getText());
//        Assert.assertEquals(firstSelectedOption.getText(), "Cherry", "Verifying Cherry is the selected option");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
