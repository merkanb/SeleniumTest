package com.eurotech.tests.day12_action_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXResult;
import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("CHROme");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void uploadFile() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:/Users/Admin/Desktop/Eurotech/Coding.jpg");
        // create a file, (shift+right click) + copy as path (""C:\Users\Admin\Desktop\Eurotech\Quality.jpg"")
        // but HAVE TO change back to forward slashes to:  C:/Users/Admin/Desktop/Eurotech/Quality.jpg

        driver.findElement(By.cssSelector(".button")).click();
    }

    @Test
    public void upload2() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);
        String filePath="src/test/resources/EurotechBatch9.txt";
        String fullPath=projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);
        chooseFile.sendKeys(fullPath);
        driver.findElement(By.cssSelector(".button")).click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
