package net.javaguides.springboot.springsecurity.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditStudentPageObject {
private WebDriver driver;
	
	public EditStudentPageObject(WebDriver driver) {
		this.driver = driver;
	}	
	
	public void clear() {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("phoneNo")).clear();
	}
	
	
	public void edit(String name, String email, String phone) {
		this.clear();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("phoneNo")).sendKeys(phone);
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/div/div[4]/input")).click();
	}
	
	public EditStudentPageObject editStudent() {
		String path= "/html/body/div/div/div/div/div/div/table/tbody/tr/td[4]/a";
		
		driver.findElement(By.xpath(path)).click();
		
		return new EditStudentPageObject(driver);
	}
	
	public String getMessageEditStudent(){
		String path= "/html/body/div/div/div/div/div/div/div/table/tbody/tr/td[1]";
		return driver.findElement(By.xpath(path)).getText();
	}
	
}
