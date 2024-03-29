package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils1Me;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(css="#dashboard-p1")
    public WebElement welcomeMessage;

    @FindBy(css=".nav__menu-item")
    public List<WebElement> menulist;           // Developers       All Posts       My Account

    @FindBy(linkText = "All Posts")
    public WebElement allPost;

    @FindBy(linkText = "Developers")
    public WebElement developers;

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[@class='btn btn-light']")
    public List<WebElement> dashboardList;          //    Edit Profile     Add Experience    Add Education

    ////tbody/tr[2]/td[2]
    @FindBy(xpath = "//td[@class='hide-sm'][1]")
    public WebElement jobTitle;

        @FindBy(xpath = "//td[@class='hide-sm']/preceding-sibling::td[1]")
//    @FindBy(xpath = "//td[@class='hide-sm']/following-sibling::td[1]")
    public WebElement companyName;
    public void navigateMenu(String menuName){

        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();

    }
    public void navigateSubMenu(String subMenuName){

        BrowserUtils1Me.hover(myAccount);
        Driver.get().findElement(By.xpath("//span[text()='"+subMenuName+"']")).click();
    }

    public void verifyTitle(String title){
        Assert.assertEquals(jobTitle.getText(),title);
    }
    public void verifyCompany(String company){
        Assert.assertEquals(companyName.getText(),company);
    }


}
