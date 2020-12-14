package net.javaguides.springboot.springsecurity.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddStudentPageObject {
private WebDriver driver;
	
	public AddStudentPageObject(WebDriver driver) {
		this.driver = driver;
	}	
	
	public void addStudent(String name, String email, String phone) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("phoneNo")).sendKeys(phone);
		String path= "/html/body/div/div/div/div/form/div/div[4]/input";
		driver.findElement(By.xpath(path)).click();
	}
	
	public String getMessageAddStudent(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String path= "/html/body/div/div/div/div/div/div/div/table/tbody/tr/td[1]";
	    String s= driver.findElement(By.xpath(path)).getText();
	    System.out.println("Valor xpath: " + s);
	    return driver.findElement(By.xpath(path)).getText();
	}
}