package actions;

import java.security.SecureRandom;

import org.openqa.selenium.WebDriver;

import Orange.HRMDemo.Base;
import pages.LandingPage;

public class LandingActions {
	public String empFirstName, empLastName;
	WebDriver driver;

	public LandingActions(WebDriver driver) {
		this.driver = driver;
	}

	LandingPage landingPage = new LandingPage();
	Base base = new Base();

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	private static final SecureRandom RANDOM = new SecureRandom();

	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
		}
		return "auto" + sb.toString().toLowerCase();
	}

	public void clickLeftLink(String linkName) {
		driver.findElement(landingPage.leftLink(linkName)).click();
	}

	public void clickTopLink(String title) {
		driver.findElement(landingPage.topLink(title)).click();
	}

	public void enterRequiredFields() {
		empFirstName = randomString(4);
		empLastName = randomString(4);
		driver.findElement(landingPage.inputField("firstName")).sendKeys(empFirstName);
		driver.findElement(landingPage.inputField("lastName")).sendKeys(empLastName);
		driver.findElement(landingPage.btnSubmit).click();
	}

	public void addEmployee() {
		clickLeftLink("PIM");
		clickTopLink("Add Employee");
		enterRequiredFields();
	}

	public void verifyEmployeeAdded() {
		String expectedFullName = empFirstName + " " + empLastName;
		base.waitForElement(landingPage.employeeName);
		String actualFullName = driver.findElement(landingPage.employeeName).getText();
		System.out.println("Expected Employee Name: " + expectedFullName);
		System.out.println("Actual Employee Name: " + actualFullName);
		if (!expectedFullName.equals(actualFullName)) {
			throw new AssertionError("Expected employee name: " + expectedFullName + ", but found: " + actualFullName);
		}
	}

	public void logout() {
		driver.findElement(landingPage.userProfileIcon).click();
		clickTopLink("Logout");
	}
}
