package net.javaguides.springboot.springsecurity.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.javaguides.springboot.springsecurity.pageobject.LoginPageObject;

public class TestLogout {
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", 
				"E:\\TDevs\\geckodriver-v0.28.0-win64\\geckodriver.exe"); //E:\TDevs\geckodriver-v0.28.0-win64
		driver= new FirefoxDriver(); //new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("localhost:8080");
	}
	
	@Test
	public void logout() {
		loginPage = new LoginPageObject(driver);
		loginPage.login("admin@admin.com", "admin123");
		String currentMessage= loginPage.logout().getLogoutMessage();
		
		assertTrue(currentMessage.contains("You have been logged out."));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
