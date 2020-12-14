package net.javaguides.springboot.springsecurity.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageObject {
private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePageObject login(String email, String pass) {
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-submit")).click();
		
		return new HomePageObject(driver);
	}
	
	public String getResultMessage() {
		return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/span")).getText();
	}
	
	public LoginPageObject logout() {
		String path= "/html/body/nav/div/div[2]/ul/li/a";
		driver.findElement(By.xpath(path)).click();	
		
		return new LoginPageObject(driver);
	}
	
	public String getLogoutMessage() {
		return driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/div")).getText();
	}

}
