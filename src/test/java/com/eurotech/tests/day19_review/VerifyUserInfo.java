package com.eurotech.tests.day19_review;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils1Me;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /*    --Login as a teacher    --Verify that login is successful    --Click on Edit Profile button
--Verify that Github name is eurotech2023    --Click on back button    --Verify that user's Apple company title is Test Automation Engineer

    */

    @Test
    public void test3() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        // give a name to the current test
        extentLogger=report.createTest("TC007 Login Test,  Login-Edit Profile-");

        extentLogger.info("Navigate to url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Login as Teacher");
        loginPage.loginWithTeacher();
//        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
//        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
//        loginPage.loginBtn.click();


//        String expectedText = "Welcome Teacher";
//        String actualText = dashboardPage.welcomeMessage.getText();
//        extentLogger.info("Verify that welcome message is "+expectedText);
//        Assert.assertEquals(actualText,expectedText);


        extentLogger.info("Verify that login is successful");
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), "Welcome Teacher");
//        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");  // FAIL --> WHY !!!!

    }

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        // give a name to the current test
        extentLogger=report.createTest("TC007 Login Test,  Login-Edit Profile-");

        extentLogger.info("Navigate to url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

//        extentLogger.info("Click I understand button");
//        loginPage.understandBtn.click();

        extentLogger.info("Login as Teacher");
        loginPage.loginWithTeacher();            // Contains understand button.click  function
//        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
//        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
//        loginPage.loginBtn.click();


        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();
        extentLogger.info("Verify that welcome message is "+expectedText);
        Assert.assertEquals(actualText,expectedText);


        extentLogger.info("Verify that login is successful");
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), "Welcome Teacher");
//        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");    // FAIL -- WHY ??

        extentLogger.info("Click on Edit Profile button");
        dashboardPage.navigateMenu("Edit Profile");


        extentLogger.info("Verify that Github name is eurotech2023");
        WebElement githubLink=driver.findElement(By.id("editprofile-from-github-input"));
        String githubLinkValue = githubLink.getAttribute("value");
        Assert.assertEquals(githubLinkValue, "teacher23");


        extentLogger.info("--Click on back button ");
        WebElement goBack=driver.findElement(By.xpath("//a[@class='btn btn-light my-1']"));
        goBack.click();

        extentLogger.info("-Verify that user's Apple company title is Teacher");
        String text = driver.findElement(By.xpath("//td[text()='EuroTech']/../td[2]")).getText();
        Assert.assertEquals(text, "Teacher");

        extentLogger.pass("Passed");

    }


    @Test
    public void userInfo() {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage = new ProfilePage();
        // 10 min
        extentLogger = report.createTest("User Info Verification");

        extentLogger.info("Navigate to http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Login as teacher");
        loginPage.loginWithTeacher();


        //                     DASHBOARD PAGE                          //

        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();

        extentLogger.info("Verify that welcome message is "+expectedText);
        Assert.assertEquals(actualText,expectedText);

        //                     PROFILE PAGE                          //
        extentLogger.info("Click on Edit Profile Button");
        dashboardPage.navigateMenu("Edit Profile");

        BrowserUtils1Me.scrollToElement(profilePage.goBack);

        String expectedGithubName = "teacher23";
        String actualGithubName = profilePage.githubName.getAttribute("value");
        System.out.println("actualGithubName = " + actualGithubName);

        extentLogger.info("Verify that github name is "+expectedGithubName);
        Assert.assertEquals(actualGithubName,expectedGithubName);

        extentLogger.info("Click on go back button");
        profilePage.goBack.click();

        //                     DASHBOARD PAGE                          //

        extentLogger.info("Verify that Apple's company Job Title is Teacher");
        String expectedJobTitle ="Teacher";
        String actualJobTitle = dashboardPage.jobTitle.getText();
        Assert.assertEquals(actualJobTitle,expectedJobTitle);

        extentLogger.info("Passed");


    }



}
