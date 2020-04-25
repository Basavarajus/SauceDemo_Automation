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
        this.username.sendKeys(new CharSequence[] { un });
        this.password.sendKeys(new CharSequence[] { pass });
        final JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", new Object[] { this.loginbutton });
        System.out.println("Successfully logged into saucedemolabs");
        return new SaucedemoHomePage();
    }
}

