package pages;

import org.openqa.selenium.By;

public class LoginPage {
	// Dynamic Xpaths
	public String inputField = "//input[@placeholder='%s']";
	public String requiredFieldErrorMsg = "//input[@name='%s']/parent::div/following-sibling::span[text()='Required']";

	// Xpaths
	public By loginButton = By.xpath("//button[@type='submit']");
	public By invalidCredErrorMsg = By.xpath("//p[text()='Invalid credentials']");

	public By inputField(String fieldName) {
		return By.xpath(String.format(inputField, fieldName));
	}

	public By requiredFieldErrorMsg(String fieldName) {
		return By.xpath(String.format(requiredFieldErrorMsg, fieldName));
	}
}
