package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.TestBase;

public class SaucedemoHomePage extends TestBase {

	@FindBy(xpath = "//*[@class='product_label']")
	WebElement Product_text;
	
	@FindBy(xpath = "//*[@class='svg-inline--fa fa-shopping-cart fa-w-18 fa-3x ']")
	WebElement Cart_Button;

	@FindBy(xpath = "//*[@class='bm-burger-button']")
	WebElement Menu_items;

	@FindBy(xpath = "//*[@class='product_sort_container']")
	WebElement Sorting_option;

	public SaucedemoHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String GetHomePageUrl() {
		return driver.getCurrentUrl();
	}
	public void IsProductTextDisplayed() {
		Product_text.isDisplayed();
	}
	public void IsCartButtonDisplayed() {
		Cart_Button.isDisplayed();
	}
	public void IsmenuItemButtonDisplayed() {
		Menu_items.isDisplayed();
	}
	public void IsSortingButtonDisplayed() {
		Menu_items.isDisplayed();
	}
}
