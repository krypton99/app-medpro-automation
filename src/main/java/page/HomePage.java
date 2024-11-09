package page;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;
import core.Constants;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {
	
	public static final String SCROLL_VIEW_PATH = "//android.widget.ScrollView/android.view.ViewGroup/";

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
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Xem Chi tiết\"]")
	private WebElement buttonSeeMore;
	
	@FindBy(how = How.XPATH, using = "//android.widget.ImageView")
	private WebElement banner;
	
	@FindBy(how = How.XPATH, using = "//*[@text='Đặt khám tại" + "\n" + " cơ sở']/../../../..")
	private WebElement featureSection;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Bệnh viện Trưng Vương\"]/../..")
	private WebElement associatedHospitalSection;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"CƠ SỞ Y TẾ\"]/..")
	private WebElement recommendedHospitalSection;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"BÁC SĨ TƯ VẤN\"]")
	private WebElement telemedicineDoctorSection;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"CHĂM SÓC\"]")
	private WebElement comprehensiveMedicalSection;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id]")
	private WebElement carouselBanner;
	
	
	public void tapOnCloseBanner() {
		
		By by =  AppiumBy.xpath("//android.widget.ImageView");
		isBannerOpened();
		
		int[] point = getElementLocation(banner);
		int width = getElementWidth(banner);
		int X = point[0] + width - 15;
		int Y = point[1] - 20;
		tapByCoordinates(X, Y);
	}
	
	//To make sure that the banner is opening
	public void isBannerOpened() {
		isElementVisibility(buttonSeeMore);
	}
	
	public boolean isFeatureSectionDisplayed() {
		return isElementVisibility(featureSection);
	}
	
	public boolean isCarouselBannerDisplayed() {
		return isElementVisibility(carouselBanner);
	}
	
	public boolean isAssociatedHospitalSectionDisplayed() {
		return isElementVisibility(associatedHospitalSection);
	}
	
	public boolean isRecommendHospitalSectionDisplayed() {
		boolean isVisible = isElementVisibility(recommendedHospitalSection);
		while(!isVisible) {
			swipeByScreenPercentage(Constants.SWIPE_UP, 50, Duration.ofSeconds(2));
			isVisible = isElementVisibility(recommendedHospitalSection);
		}
		return isVisible;
	}
	
	public boolean isDoctorTelemedSectionDisplayed() {
		boolean isVisible = isElementVisibility(telemedicineDoctorSection);
		while(!isVisible) {
			swipeByScreenPercentage(Constants.SWIPE_UP, 50, Duration.ofSeconds(2));
			isVisible = isElementVisibility(telemedicineDoctorSection);
		}
		return isVisible;
	}
	
	public boolean isComprehensiveMedicalDisplayed() {
		boolean isVisible = isElementVisibility(comprehensiveMedicalSection);
		while(!isVisible) {
			swipeByScreenPercentage(Constants.SWIPE_UP, 50, Duration.ofSeconds(2));
			isVisible = isElementVisibility(comprehensiveMedicalSection);
		}
		return isVisible;
	}
	
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

