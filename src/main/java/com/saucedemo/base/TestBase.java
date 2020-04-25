package com.saucedemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	 public static WebDriver driver;
	    public static Properties prop;
	    
	    public TestBase() {
	        try {
	            TestBase.prop = new Properties();
	            final FileInputStream ip = new FileInputStream(String.valueOf(System.getProperty("user.dir")) + "/resource/config.properties");
	            TestBase.prop.load(ip);
	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (IOException e2) {
	            e2.printStackTrace();
	        }
	    }
	    
	    public static void initialization() {
	        final String BrowserName = TestBase.prop.getProperty("Browser");
	        if (BrowserName.equals("chrome")) {
	            System.setProperty("webdriver.chrome.driver", "C:\\Users\\basavaraju.s\\Desktop\\Automation_Project_Master\\saucedemo\\resource1\\chromedriver.exe");
	            TestBase.driver = (WebDriver)new ChromeDriver();
	        }
	        else if (BrowserName.equals("FF")) {
	            System.setProperty("webdriver.gecko.driver", "C:\\Users\\basavaraju.s\\Desktop\\Automation_Project_Master\\saucedemo\\resource1\\geckodriver.exe");
	            TestBase.driver = (WebDriver)new FirefoxDriver();
	        }
	        TestBase.driver.manage().window().maximize();
	        TestBase.driver.manage().deleteAllCookies();
	        TestBase.driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
	        TestBase.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	        TestBase.driver.get(TestBase.prop.getProperty("url"));
	    }
	
	

}
