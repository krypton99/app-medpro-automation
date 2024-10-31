package page;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

	public HomePage(AndroidDriver androidDriver) {
		super(androidDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Đặt khám" + "\n" + " Bác sĩ\"]")
	private WebElement featureDoctor;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid:id/navCategories")
	private WebElement categoryMenu;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.homeV3:id/searchBar")
	private WebElement searchBar;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid:id/navProfile")
	private WebElement account;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid:id/etQuery")
	private WebElement searchInput;
	
	public void tapOnCategoryMenu() {
		tapByElement(categoryMenu);
	}
	
	public void tapOnSearchBar() {
		tapByElement(searchBar);
	}
	
	public void tapOnAccount() {
		tapByElement(account);
	}
	
	public boolean isDoctorDisplay() {
		return isElementVisibility(featureDoctor);
	}
	
	public void tapOnDoctor() {
		tapByElement(featureDoctor);
	}
	
	public void sendTextToSearchBar(String searchKey) {
		enterText(searchInput, searchKey);
		tapByCoordinates(656, 1118);
	}
	
	public boolean isSearchBarDisplay() {
		return isElementVisibility(searchBar);
	}
	
	public void enterKey() {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.ENTER).perform();
	}

}

