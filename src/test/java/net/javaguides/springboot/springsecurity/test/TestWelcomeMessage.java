package net.javaguides.springboot.springsecurity.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import net.javaguides.springboot.springsecurity.Application;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class TestWelcomeMessage {
	private WebDriver driver;
	 
	@Before
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", 
				"E:\\TDevs\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		//driver = new ChromeDriver();
		driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("localhost:8080");
	}
	
	@Test
	public void pageTitleShouldAppear() {
		String pageTitle = driver.getTitle();		  
		assertEquals("Registration", pageTitle);	    
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
