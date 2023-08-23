package com.eurotech.tests.day12_action_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetTextTask {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // navigate to "https://the-internet.herokuapp.com/hovers"
    // hover over each image one by one and assert the text is displayed


    @Test
    public void hoverOverList() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> threeImages = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> texts = driver.findElements(By.xpath("//img[@alt='User Avatar']/following-sibling::div//h5"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < threeImages.size(); i++) {
            actions.moveToElement(threeImages.get(i)).perform();
            WebElement textElement = texts.get(i);
            Assert.assertTrue(textElement.isDisplayed(), "TextElement is NOT Displayed for the image " + i);
            System.out.println("Image " + (i + 1) + " text is = " + textElement.getText());
        }
    }

    @Test
    public void hoverover() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        for (int i = 1; i <= 3; i++) {
            String imageXpath = "(//div[@class='figure']//img)[" + i + "]";   // dynamic xpath
            WebElement image = driver.findElement(By.xpath(imageXpath));

            Actions actions=new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(image).perform();

            String imageText="//h5[text()='name: user"+i+"']";      // dynamic xpath
            WebElement text=driver.findElement(By.xpath(imageText));
            System.out.println(text.getText());
            Assert.assertTrue(text.isDisplayed(), "text is NOT displayed for the image "+i);
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
