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
import core.Label;
import core.Constants;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

	public String SCROLL_VIEW_PATH = String.format("//android.widget.ScrollView/android.view.ViewGroup/");

	public String featureBookingAtHospital = String.format("//*[@text='%s']", Label.FEATURE_BOOKING_AT_HOSPITAL.vi );

	public String featureBookingByDoctor = String.format("//*[@text='%s']",  Label.FEATURE_BOOKING_BY_DOCTOR.vi);

	public String featureHealthScreening = String.format("//*[@text='%s']",  Label.FEATURE_HEALTH_SCREENING.vi);

	public String featureMedicalExaminationResults = String.format("//*[@text='%s']",Label.FEATURE_MEDICAL_EXAMINATION_RESULT.vi);

	public String featureTelemed = String.format("//*[@text='%s']" , Label.FEATURE_TELEMED.vi);

	public String featureTesting = String.format("//*[@text='%s']" , Label.FEATURE_TESTING.vi);

	public String featureVaccine = String.format("//*[@text='%s']" , Label.FEATURE_VACCINE.vi);
	
	public String associatedHospitalSection = String.format("//*[@text='%s']" , Label.SECTION_ASSOCIATED_HOSPITAL.vi);
	
	public String recommendedHospitalSection = String.format("//*[@text='%s']/..", Label.SECTION_HEALTH_FACILITIES.vi);
	
	public String telemedicineDoctorSection = String.format("//*[@text='%s']", Label.SECTION_TELEMED);
	
	public String comprehensiveMedicalSection = String.format("//*[@text='%s']", Label.SECTION_HEALTH_SCREENING.vi);
	
	public String cskhPhone = String.format("//android.widget.TextView[@text='%s']/..", Label.CSKH_PHONE.vi);
	
	public String cskhMessenger = String.format("//android.widget.TextView[@text='%s']/..", Label.CSKH_MESSENGER.vi);
			
	public String cskhZalo = String.format("//android.widget.TextView[@text='%s']/..", Label.CSKH_ZALO.vi);	
	
	public String cskhClose = String.format("//android.widget.TextView[@text='%s']", Label.CSKH_CLOSE.vi);
		
	public String noInternetMsg = String.format("//android.widget.TextView[@text='%s']", "Vui lòng kiểm tra lại Wifi hoặc 3G");
	

	public HomePage(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Đặt khám" + "\n" + " Bác sĩ\"]")
	private WebElement featureDoctor;

	@FindBy(how = How.ID, using = "//android.widget.FrameLayout[@resource-id=\"com.zing.zalo:id/zalo_view_container\"]")
	private WebElement zaloApp;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid:id/etQuery")
	private WebElement searchInput;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Xem Chi tiết\"]")
	private WebElement buttonSeeMore;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView")
	private WebElement banner;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id]")
	private WebElement carouselBanner;
	
	@FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView")
	private WebElement cskhButton;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"android:id/title\"]")
	private WebElement confirmZalo;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id=\"android:id/button_once\"]")
	private WebElement justOne;
	

	public void tapOnCloseBanner() {
		By by = AppiumBy.xpath("//android.widget.ImageView");
		isBannerOpened();

		int[] point = getElementLocation(banner);
		int width = getElementWidth(banner);
		int X = point[0] + width - 15;
		int Y = point[1] - 20;
		tapByCoordinates(X, Y);
	}

	// Feature Section
	public WebElement getElement(String dynamicLocator) {
		System.out.println(dynamicLocator);
		return driver.findElement(By.xpath(dynamicLocator));
	}

	// To make sure that the banner is opening
	public boolean isBannerOpened() {
		return isElementVisibility(buttonSeeMore);
	}
	
	public boolean isZaloOpened() {
		System.out.print(driver.getCurrentPackage());
		return driver.getCurrentPackage().equals("com.zing.zalo");
	}
	
	public boolean isMessengerOpened() {
		System.out.print(driver.getCurrentPackage());
		return driver.getCurrentPackage().equals("com.facebook.orca");
	}

	public boolean isFeatureSectionDisplayed() {
		return isElementVisibilityBy(By.xpath(featureBookingAtHospital));
	}

	public boolean isAssociatedHospitalSectionDisplayed() {
		return isElementVisibilityBy(By.xpath(associatedHospitalSection));
	}

	// booking by doctor - Đặt khám bác sĩ
	public boolean isFeatureBookingByDoctorDisplayed() {
		return isElementVisibilityBy(By.xpath(featureBookingByDoctor));
	}

	// booking at hospital - Đặt khám tại cơ sở
	public boolean isFeatureBookingAtHospitalDisplayed() {
		return isElementVisibilityBy(By.xpath(featureBookingAtHospital));
	}

	// health screening - Gói sức khỏe toàn diện
	public boolean isFeatureHealthScreeningDisplayed() {
		return isElementVisibilityBy(By.xpath(featureHealthScreening));
	}

	// testing - Đặt lịch xét nghiệm
	public boolean isFeatureTestingDisplayed() {
		return isElementVisibilityBy(By.xpath(featureTesting));
	}

	// vaccine - Tiêm chủng
	public boolean isFeatureVaccineDisplayed() {
		return isElementVisibilityBy(By.xpath(featureVaccine));
	}

	// telemed - Tư vấn khám bệnh qua video
	public boolean isFeatureTelemedDisplayed() {
		return isElementVisibilityBy(By.xpath(featureTelemed));
	}

	// medical examination results - Tra cứu kết quả khám bệnh
	public boolean isFeatureMedicalExaminationResultsDisplayed() {
		return isElementVisibilityBy(By.xpath(featureMedicalExaminationResults));
	}
	
	// popup no internet connection - Popup thông báo vui lòng kiểm tra lại wifi hoặc 3G
	public boolean isNoConnectionPopupDisplay() {
		return isElementVisibilityBy(By.xpath(noInternetMsg));
	}
	
	public boolean isCarouselBannerDisplayed() {
		return isElementVisibility(carouselBanner);
	}

	public boolean isRecommendHospitalSectionDisplayed() {
		boolean isVisible = isElementVisibilityBy(By.xpath(recommendedHospitalSection));
		while (!isVisible) {
			swipeByScreenPercentage(Constants.SWIPE_UP, 50, Duration.ofSeconds(2));
			isVisible = isElementVisibilityBy(By.xpath(recommendedHospitalSection));
		}
		return isVisible;
	}

	public boolean isDoctorTelemedSectionDisplayed() {
		boolean isVisible = isElementVisibilityBy(By.xpath(telemedicineDoctorSection));
		while (!isVisible) {
			swipeByScreenPercentage(Constants.SWIPE_UP, 50, Duration.ofSeconds(2));
			isVisible = isElementVisibilityBy(By.xpath(telemedicineDoctorSection));
		}
		return isVisible;
	}

	public boolean isComprehensiveMedicalDisplayed() {
		System.out.println(comprehensiveMedicalSection);
		boolean isVisible = isElementVisibilityBy(By.xpath(comprehensiveMedicalSection));
		while (!isVisible) {
			swipeByScreenPercentage(Constants.SWIPE_UP, 50, Duration.ofSeconds(2));
			isVisible = isElementVisibilityBy(By.xpath(comprehensiveMedicalSection));
		}
		return isVisible;
	}
	
	

	//----------------------------------------TAP Element-------------------------------------------//
	

	
	public void tapOnCSKH() {
		tapByElement(cskhButton);
	}
	
	public void tapOnCSKHPhone() {
		tapByElementBy(By.xpath(cskhPhone));
	}
	
	public void tapOnCSKHMess() {
		tapByElementBy(By.xpath(cskhMessenger));
	}
	
	public void tapOnCSKHZalo() {
		tapByElementBy(By.xpath(cskhZalo));
	}

	public boolean isDoctorDisplay() {
		return isElementVisibility(featureDoctor);
	}

	public void tapOnDoctor() {
		tapByElement(featureDoctor);
	}
	
	public void tapOnConfirmZalo() {
		tapByElement(confirmZalo);
	}
	
	public void tapOnJustOneBtn() {
		tapByElement(justOne);
	}
 
	public void sendTextToSearchBar(String searchKey) {
		enterText(searchInput, searchKey);
		tapByCoordinates(656, 1118);
	}

	public void enterKey() {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.ENTER).perform();
	}

}
