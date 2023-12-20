package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PostsPage extends BasePage{

    @FindBy(id = "post-form-title")
    public WebElement titleInput;

    @FindBy(id = "post-form-textarea")
    public WebElement postInput;

    @FindAll({    //To use multiple locator if at least one of them is matching it will find the web element.     ONE MATCHES OK !!!
            @FindBy(css = "#post-form-btn"),              //or
            @FindBy(xpath = "//input[@id='post-form-btn']")})
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()='Post Created']")
    public WebElement postCreatedMessage;

    public void postComment(String titleText, String postText) {  // this postComment() method send keys(params) to corresponding WE adresses and DO Assertion !!!
        titleInput.sendKeys(titleText);
        postInput.sendKeys(postText);
        submitButton.click();
        Assert.assertEquals(postCreatedMessage.getText(), "Post Created", "Verifying whether the post is created successfully");
    }




}
