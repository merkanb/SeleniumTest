package com.eurotech.tests.day10_typeOfElements3;

import com.beust.ah.A;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void popUp() throws InterruptedException {
        /* navigate to  "http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=55ad9"
        click comfirm       click yes       verif the message at the end -
         */
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=55ad9");
        WebElement confirmButton = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmButton.click();
        WebElement yesButton = driver.findElement(By.xpath("(//span[text()='Yes'])[2]"));
        yesButton.click();
        Thread.sleep(1000);
        String expectedMessage="You have accepted";
        WebElement message = driver.findElement(By.xpath("//p[text()='You have accepted']"));
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Verifying that the message is 'You have accepted' ");

    }

    @Test
    public void testJSAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert=driver.switchTo().alert();      // Alert interface coming from Selenium...
        Thread.sleep(1000);
        alert.accept();             //  alert.accept()

        // Click "Click for JS Confirm"        // Cancel (dismiss)
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        alert.dismiss();

        // Click "Click for JS Prompt"        // Enter "Eurotech is here"        // Accept
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        alert.sendKeys("Euro-tech");            //   alert.sendKeys()
        Thread.sleep(5000);
        alert.accept();

        // --> verify the result (You entered: Euro-tech)
        String text = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(text.contains("Euro"), "Verifying message if contains Euro text");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
