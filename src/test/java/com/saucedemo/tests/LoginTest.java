
package com.saucedemo.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.saucedemo.pages.SaucedemoHomePage;
import com.saucedemo.pages.SaucedemoLoginPage;
import com.saucedemo.base.TestBase;

public class LoginTest extends TestBase
{
    SaucedemoLoginPage loginpage;
    SaucedemoHomePage Homepage;
    
    @BeforeMethod
    public void setup() {
        initialization();
        this.loginpage = new SaucedemoLoginPage();
    }
    
    @Test
    public void loginpagetitle() {
        final String loginpagetitle = this.loginpage.validateLoginPageTitle();
        Assert.assertEquals(loginpagetitle, "Swag Labs");
    }
    
    @Test
    public void logintest() {
        Homepage =loginpage.Login(LoginTest.prop.getProperty("username"), LoginTest.prop.getProperty("pass"));
        System.out.println(Homepage);
    }
    
    @AfterMethod
    public void tearDown() {
        LoginTest.driver.quit();
    }
}