package com.saucedemo.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.SaucedemoHomePage;
import com.saucedemo.pages.SaucedemoLoginPage;

public class HomePageTest extends TestBase {
	
	SaucedemoHomePage Homepage;
	SaucedemoLoginPage LoginPage;
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage= new SaucedemoLoginPage();
		Homepage=LoginPage.Login(prop.getProperty("username"),prop.getProperty("pass"));
	}
	
	@Test(priority=1)
	public void getHomepageUrl()
	{
		Homepage.GetHomePageUrl();
	}
	
	@Test(priority=2)
	public void IsProductTextDisplayed() {
		 Homepage.IsProductTextDisplayed();;
	}
	@Test(priority=3)
	public void IsCartButtonDisplayed() {
		 Homepage.IsCartButtonDisplayed();
	}	
	@Test(priority=4)
	public void IsSortingOptionDisplayed() {
		 Homepage.IsSortingButtonDisplayed();
	}
	@Test(priority=5)
	public void IsMenuDisplayed() {
		 Homepage.IsmenuItemButtonDisplayed();;
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
