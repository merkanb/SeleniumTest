package com.eurotech.tests.day16_POM2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils1Me;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardTest extends TestBase {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    @Test
    public void testName() {
        /* Navigate to http://eurotech.study/login
Login with teacher credentials
Get the text of the dashboard menu list
Verify that menu list is
Developers
All Posts
My Account
*/
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText= "Welcome Teacher";
//        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),"Welcome Teacher");
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText);

//        ArrayList<String> expectedList=new ArrayList<>();
//        expectedList.add("Developers");
//        expectedList.add("All Posts");
//        expectedList.add("My Account");
        ArrayList<String> expectedList=new ArrayList<>(Arrays.asList("Developers", "All Posts", "My Account"));

        //1. way
        ArrayList<String> actualList=new ArrayList<>();
        List<WebElement> dashboardMenu=dashboardPage.menulist;
        for (WebElement menu : dashboardMenu) {
//            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(actualList,expectedList);

        // 2. way
        List<String>actualList1= BrowserUtils1Me.getElementsText(dashboardPage.menulist);
        Assert.assertEquals(actualList1,expectedList);
        System.out.println("actualList1 = " + actualList1);

        // 3. way
        Assert.assertEquals(BrowserUtils1Me.getElementsText(dashboardPage.menulist), expectedList);

    }

}
