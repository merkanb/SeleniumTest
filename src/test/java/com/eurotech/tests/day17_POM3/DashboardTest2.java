package com.eurotech.tests.day17_POM3;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.Pages.PostsPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils1Me;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardTest2 extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    PostsPage postsPage = new PostsPage();

    /*    go to "http://eurotech.study/login"    Login with teacher credentials    Verify login is succesful
    Verify following menu   - Edit Profile  - Add Experience  - Add Education     */

    @Test
    public void verifyList1() {

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedText, "Login verification failed");
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList("Edit Profile", "Add Experience", "Add Education"));
        List<WebElement> dashboardList = driver.findElements(By.xpath("//a[@class='btn btn-light']"));

        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println(dashboardList.get(i).getText());
            Assert.assertTrue(dashboardList.get(i).getText().equals(expectedList.get(i)), "element text do not match");
        }
    }

    @Test
    public void verifyList() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();
        Assert.assertEquals(actualText, expectedText, "Login verification failed");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");

        List<String> actualList = new ArrayList<>();
//      1st way
//        for(WebElement listItem : dashboardPage.dashboardList){
//            actualList.add(listItem.getText());
//        }
//        Assert.assertEquals(actualList, expectedList, "Verifying dashboard list items");

// 2nd way
        Assert.assertEquals(BrowserUtils1Me.getElementsText(dashboardPage.dashboardList), expectedList);       // utilities method !!!
    }



    /*      go to "http://eurotech.study/login"     Login with teacher credentials      Verify login is successful
Navigate to My Account and My Posts and verify that submit button is visible    Navigate to Log Out and verify that logout successful
*/
    @Test
    public void logout1() {                     // PASS WHEN RUN individually
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedText,"Login verification failed");

        dashboardPage.navigateSubMenu("My Posts");
        Assert.assertTrue(postsPage.submitButton.isDisplayed());
        loginPage.logout.click();       // defined in basePage, able to reach via child class obj. (loginPage)
        Assert.assertTrue(driver.getTitle().equals("DevEx"), "It Is NOT Login Page");
    }

    @Test
    public void logout() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedText,"Login verification failed");
// 1st way of navigating to My Account menu
        //        dashboardPage.navigateMenu("My Account");         // POM
        // 2nd way of navigating to My Account menu
        BrowserUtils1Me.hover(dashboardPage.myAccount);        // UTILITIES and   // POM
        dashboardPage.navigateSubMenu("My Posts");       // POM

        // 1st way of verifying Submit button is displayed
//        Assert.assertTrue(postsPage.submitButton.isDisplayed());

        // 2nd way of verifying Submit button is displayed
        BrowserUtils1Me.verifyElementDisplayed(postsPage.submitButton);        // UTILITIES and   // POM
        Assert.assertEquals(postsPage.submitButton.getAttribute("value"), "Submit");
        // logout
        BrowserUtils1Me.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("Logout");

        // verify logout
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        Thread.sleep(3000);
    }

    /*  Go to http://www.eurotech.study/    Login with teacher credentials  Navigate to My Account and navigate to My Posts
Fill the title and post area    Click submit button     Verify that post saved successfully     */
    @Test
    public void postComment() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();
        Assert.assertEquals(actualText, expectedText, "Login verification failed");

        BrowserUtils1Me.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("My Posts");

        String titleText = "Page Object Model";
        String postText = "Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements.";

//        postsPage.titleInput.sendKeys(titleText);
//        postsPage.postInput.sendKeys(postText);
//        postsPage.submitButton.click();
//        Assert.assertEquals(postsPage.postCreatedMessage.getText(), "Post Created", "Verifying whether the post is created successfully");

        postsPage.postComment(titleText, postText);         // POM  predefined postComment() method ( sends keys and DO Assertion !!!)

    }
}
