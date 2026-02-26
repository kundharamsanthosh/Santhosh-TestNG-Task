package actions;

import org.openqa.selenium.WebDriver;

import pages.DashboardPage;

public class DashboardActions {
	public WebDriver driver;

	public DashboardActions(WebDriver driver) {
		this.driver = driver;
	}

	DashboardPage dashboardPage = new DashboardPage();

	public boolean isDashboardTitleDisplayed() {
		try {
			return driver.findElement(dashboardPage.dashboardTitle).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
