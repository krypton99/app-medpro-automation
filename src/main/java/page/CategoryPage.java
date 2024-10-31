package page;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CategoryPage extends BasePage{
	@FindBy(how = How.XPATH, using = "//*[@text='Phụ kiện thời trang']")
	private WebElement fashionAccessories;
	
	@FindBy(how = How.XPATH, using = "//*[@text='Phụ kiện thời trang nam']")
	private WebElement menFashion;
	
	@FindBy(how = How.XPATH, using = "//*[@text='Gợi ý cho bạn']/..")
	private WebElement suggestMenu;
	
	@FindBy(how = How.XPATH, using = "//*[@text='Gợi ý cho bạn']/../..")
	private WebElement sideMenu;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.category2:id/ervRight")
	private WebElement categoryBody;
	
	@FindBy(how = How.XPATH, using = "(//*[@resource-id='vn.tiki.app.tikiandroid.category2:id/tvTitle'])[1]")
	private WebElement firstSection;
	
	@FindBy(how = How.XPATH, using = "//androidx.recyclerview.widget.RecyclerView[@resource-id='vn.tiki.app.tikiandroid.category2:id/ervRight']//*[@resource-id='vn.tiki.app.tikiandroid.category2:id/tvContent']")
	private WebElement rightTitle;
	
	public CategoryPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}
	
	
	public void tapOnFashionAccessories() {
		tapByElement(fashionAccessories);
	}
	
	public void tapOnCategoryByName(String name) {
		WebElement e = getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(String.format("//*[@text='%s']", name))));
		tapByElement(e);
	}
	
	public void tapOnMenFashion() {
		tapByElement(menFashion);
	}
	
	public boolean isSuggestMenuDisplay() {
		return isElementVisibility(suggestMenu);
	}
	
	public void scrollToFashionAccessories() {
		swipeUpByElementHeightAndWidth(sideMenu, 5);
	}
	
	public void scrollToMenFashion() {
		swipeUpByElementHeightAndWidth(categoryBody, 2);
	}
	
	public String getFirstSectionText() {
		return getText(firstSection);
	}
	
	public String getRightTitleText() {
		return getText(rightTitle);
	}
}
