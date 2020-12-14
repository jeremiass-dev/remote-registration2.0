package net.javaguides.springboot.springsecurity.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject {
private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getResultMessage() {
		String s= driver.findElement(By.xpath("/html/body/nav/div/div[1]/a")).getText();
		System.out.println("Valor xpath: " + s);
		return driver.findElement(By.xpath("/html/body/nav/div/div[1]/a")).getText();
	}
	
	public AddStudentPageObject addNewStudent(String name, String email, String phone) {
		AddStudentPageObject aspo= new AddStudentPageObject(driver);
		String xpath= "/html/body/div/div/div/div/p/a";
		driver.findElement(By.xpath(xpath)).click();
		aspo.addStudent(name, email, phone);
		return aspo;
	}
	
	public EditStudentPageObject editStudent(String name, String email, String phone) {
		EditStudentPageObject espo= new EditStudentPageObject(driver);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/table/tbody/tr/td[4]/a")).click();
		
		espo.edit(name, email, phone);
		return espo;
	}
	
	public void deleteStudent() {
		String path= "/html/body/div/div/div/div/div/div/div/table/tbody/tr/td[5]/a";
		
		driver.findElement(By.xpath(path)).click();
		
	}
	
	public String getMessageDeleteStudent() {
		String path= "/html/body/div/div/div/div/div/h2";
	    String s= driver.findElement(By.xpath(path)).getText();
	    System.out.println("Valor xpath: " + s);
	    return driver.findElement(By.xpath(path)).getText();
	}

}
