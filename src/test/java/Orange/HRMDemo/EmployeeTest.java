package Orange.HRMDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.AdminActions;
import actions.DashboardActions;
import actions.LandingActions;
import actions.LoginActions;

public class EmployeeTest extends BaseTest {
	LoginActions loginActions;
	DashboardActions dashboardActions;
	LandingActions landingActions;
	AdminActions adminActions;

	@BeforeMethod
	public void beforeMethod() {
		loginActions = new LoginActions(getDriver());
		dashboardActions = new DashboardActions(getDriver());
		landingActions = new LandingActions(getDriver());
		adminActions = new AdminActions(getDriver());
	}

	@Test
	public void createEmployee() {
		loginActions.Login("Admin", "admin123");
		Assert.assertTrue(dashboardActions.isDashboardTitleDisplayed(),
				"Dashboard title is not displayed, login might have failed.");
		landingActions.addEmployee();
		landingActions.verifyEmployeeAdded();
	}
}
