package pages;

import org.openqa.selenium.By;

public class LandingPage {
	public String leftLink = "//span[text()='%s']";
	public String topLink = "//a[text()='%s']";
	public String inputField = "//input[@name='%s']";

	public By leftLink(String linkName) {
		return By.xpath(String.format(leftLink, linkName));
	}

	public By topLink(String title) {
		return By.xpath(String.format(topLink, title));
	}

	public By inputField(String fieldName) {
		return By.xpath(String.format(inputField, fieldName));
	}

	public By btnSubmit = By.xpath("//button[@type='submit']");

	public By employeeName = By.xpath("//div[contains(@class,'employee-name')]/h6");

	public By userProfileIcon = By.xpath("//span[contains(@class,'userdropdown')]");
}
