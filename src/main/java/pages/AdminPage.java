package pages;

import org.openqa.selenium.By;

public class AdminPage {
	public String btn = "//i[contains(@class,'%s')]";
	public String drpDwnSelect = "//label[text()='%s']/parent::div/following-sibling::div//div[contains(text(),'Select')]";
	public String drpDwnIcon = "//label[text()='%s']/parent::div/following-sibling::div//i[contains(@class,'%s')]";

	public By Btn(String btnName) {
		return By.xpath(String.format(btn, btnName));
	}

	public By drpDwnSelect(String fieldName) {
		return By.xpath(String.format(drpDwnSelect, fieldName));
	}

	public By drpDwnIcon(String fieldName, String iconName) {
		return By.xpath(String.format(drpDwnIcon, fieldName, iconName));
	}
}
