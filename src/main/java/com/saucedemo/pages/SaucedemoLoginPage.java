package com.saucedemo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.TestBase;

public class SaucedemoLoginPage extends TestBase
{
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginbutton;
    
    public SaucedemoLoginPage() {
        PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    
    public SaucedemoHomePage Login(final String un, final String pass) {
        username.sendKeys(un);
        password.sendKeys(pass);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginbutton );
        System.out.println("Successfully logged into saucedemolabs");
        return new SaucedemoHomePage();
    }
}

