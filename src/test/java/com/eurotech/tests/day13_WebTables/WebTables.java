package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.xpath("//button[@id='ez-accept-necessary']")).click();
        WebElement tableTitle = driver.findElement(By.xpath("//span[text()='Demo Webtable 2 (Dynamic Table)']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",tableTitle);    // scroll to the WE
    }


    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println("table.getText() = " + table.getText());     // get the whole table text
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//*[text()='Structure']/../../th"));
        System.out.println("headers.size() = " + headers.size());
        for (WebElement header : headers) {
            System.out.println("header = " + header.getText());
        }
    }

    @Test
    public void getAllRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("rows.size() = " + rows.size());

        for (WebElement row : rows) {
            System.out.println("row.getText() = " + row.getText());
        }

        System.out.println(".........");

        System.out.println(driver.findElement(By.xpath("//table[@border='1']/tbody/tr[3]")).getText());  // 3nd row

        System.out.println("..........");

        for (int i = 1; i <= rows.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//table[@border='1']/tbody/tr[" + i + "]")).getText());
        }
    }

    @Test
    public void getAllCellsInOneRow() {
        List<WebElement> financialCenterCells = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[4]/td"));
        for (WebElement cell : financialCenterCells) {
            System.out.println(cell.getText());
        }
    }

    @Test
    public void getOneCell() {
        System.out.println(driver.findElement(By.xpath("//table[@border='1']/tbody/tr[4]//td[1]")).getText());
    }

}
