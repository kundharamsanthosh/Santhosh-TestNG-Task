package Orange.HRMDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().get("https://opensource-demo.orangehrmlive.com");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Element located: " + getDriver().findElement(locator).getText());
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
