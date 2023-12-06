package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {                // it is abstract class !!

public BasePage(){
    PageFactory.initElements(Driver.get(),this);
}

@FindBy(xpath = "(//span[@class='hide-sm'])[1]")
public static WebElement logout;

}
