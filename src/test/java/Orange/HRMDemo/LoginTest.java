package Orange.HRMDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actions.DashboardActions;
import actions.LandingActions;
import actions.LoginActions;

public class LoginTest extends BaseTest {

	LoginActions loginActions;
	DashboardActions dashboardActions;
	LandingActions landingActions;

	@BeforeMethod
	public void beforeMethod() {
		loginActions = new LoginActions(getDriver());
		dashboardActions = new DashboardActions(getDriver());
		landingActions = new LandingActions(getDriver());
	}

	@Test
	public void validCredentials() {
		loginActions.Login("Admin", "admin123");
		Assert.assertTrue(dashboardActions.isDashboardTitleDisplayed(),
				"Dashboard title is not displayed, login might have failed.");
	}

	@Test
	public void invalidCredentials() {
		loginActions.Login("Admin", "wrongpassword");
		Assert.assertTrue(loginActions.isInvCredErrorMessageDisplayed(), "Error message is not displayed for invalid");
	}

	@Test
	public void emptyCredentials() {
		loginActions.Login("", "");
		Assert.assertTrue(loginActions.verifyRequiredErrorMessage("username"),
				"Required error message is not displayed for empty username");
		Assert.assertTrue(loginActions.verifyRequiredErrorMessage("password"),
				"Required error message is not displayed for empty password");
	}

	@DataProvider(name = "multipleCredentials")
	public Object multipleCredentials() {
		return new Object[][] { { "Admin", "admin123" }, // Valid credentials
				{ "Admin", "wrongpassword" }, // Invalid password
				{ "", "" }, // Empty credentials
				{ "Admin", "" }, // Empty password
		};
	}

	@Test(dataProvider = "multipleCredentials")
	public void testMMultipleCredentials(String username, String password) {
		loginActions.Login(username, password);

		if (username.equals("Admin") && password.equals("admin123")) {
			Assert.assertTrue(dashboardActions.isDashboardTitleDisplayed(),
					"Dashboard title is not displayed, login might have failed.");
			landingActions.logout();
		} else if (username.isEmpty() || password.isEmpty()) {
			if (username.isEmpty()) {
				Assert.assertTrue(loginActions.verifyRequiredErrorMessage("username"),
						"Required error message is not displayed for empty username");
			}
			if (password.isEmpty()) {
				Assert.assertTrue(loginActions.verifyRequiredErrorMessage("password"),
						"Required error message is not displayed for empty password");
				refreshPage();
			}
		} else {
			Assert.assertTrue(loginActions.isInvCredErrorMessageDisplayed(),
					"Error message is not displayed for invalid credentials");
		}
	}
}
