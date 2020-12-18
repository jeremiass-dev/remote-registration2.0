package net.javaguides.springboot.springsecurity.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import net.javaguides.springboot.springsecurity.Application;
import net.javaguides.springboot.springsecurity.pageobject.HomePageObject;
import net.javaguides.springboot.springsecurity.pageobject.LoginPageObject;
import org.junit.runners.MethodSorters;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAddEditDelete {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", 
				"E:\\TDevs\\geckodriver-v0.28.0-win64\\geckodriver.exe"); //E:\TDevs\geckodriver-v0.28.0-win64
		driver= new FirefoxDriver(); //new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("localhost:8080");
	}
	
	
	@Test
	public void t01_addNewStudent() {
		loginPage = new LoginPageObject(driver);
		loginPage.login("admin@admin.com", "admin123");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage= new HomePageObject(driver);
		String userAdd= homePage.addNewStudent("Juan Barrida", "juanbarrida@admin.com", "23231212").
				getMessageAddStudent();
		assertEquals("Juan Barrida", userAdd);
	}

	@Test
	public void t02_editStudent() {
		loginPage = new LoginPageObject(driver);
		loginPage.login("admin@admin.com", "admin123");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage= new HomePageObject(driver);
		
		String userEdit= homePage.editStudent("cambio", "cambio@admin.com", "0000").getMessageEditStudent();
		assertEquals("cambio", userEdit);
	}
	
	@Test
	public void t03_deleteStudent() {
		loginPage = new LoginPageObject(driver);
		loginPage.login("admin@admin.com", "admin123");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage= new HomePageObject(driver);
		
		homePage.deleteStudent();
		String userDelete= homePage.getMessageDeleteStudent();
		assertEquals("No hay estudiantes!!!", userDelete);
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
