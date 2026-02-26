package actions;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class LoginActions {
	public WebDriver driver;

	public LoginActions(WebDriver driver) {
		this.driver = driver;
	}

	LoginPage loginPage = new LoginPage();

	public void Login(String username, String password) {
		driver.findElement(loginPage.inputField("Username")).sendKeys(username);
		driver.findElement(loginPage.inputField("Password")).sendKeys(password);
		driver.findElement(loginPage.loginButton).click();
	}

	public Boolean verifyRequiredErrorMessage(String fieldName) {
		Boolean isDisplayed = false;
		try {
			driver.findElement(loginPage.requiredFieldErrorMsg(fieldName)).isDisplayed();
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
		}

		return isDisplayed;
	}

	public boolean isInvCredErrorMessageDisplayed() {
		try {
			return driver.findElement(loginPage.invalidCredErrorMsg).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isErrorMessageDisplayed() {
		try {
			return driver.findElement(loginPage.invalidCredErrorMsg).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
