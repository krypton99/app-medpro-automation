package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;
import core.CommonFunction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductsPage extends BasePage {

	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid:id/vCardView")
	private List<WebElement> productList;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productList2:id/filter_icon_overlay")
	private WebElement filter;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productList2:id/btn_apply")
	private WebElement applyBtn;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productList2:id/recyclerView")
	private WebElement productView;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productList2:id/tv_title")
	private WebElement filterTitle;
		
	@FindBy(how = How.XPATH, using = "//*[@resource-id='vn.tiki.app.tikiandroid.productList2:id/tv_title']/../..")
	private WebElement filterLayout;

	public ProductsPage(AndroidDriver androidDriver) {
		super(androidDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void scrollToProduct() {
		swipeUpByElementHeightAndWidth(productView, 1);
	}
	
	public void scrollToProductWhenFiltered() {
		for(int i = 0; i < 1; i++) {
			swipe(300, 1160, 300, 580, Duration.ofSeconds(3));
		}
	}
	
	public void isFilterDisplay() {
		isElementVisibility(filter);
	}
	
	public void isFilterTitleDisplay() {
		isElementVisibility(filterTitle);
	}
	
	public void tapOnProductByIndex(int i) {
		tapByElement(productList.get(i));
	}
	
	public long getProductPriceByIndex(int i) {
		WebElement e = productList.get(i);
		String price = getText(e.findElement(AppiumBy.xpath(".//*[@resource-id='vn.tiki.app.tikiandroid:id/productV2Price']")));
		return CommonFunction.priceToLong(price) ;
	}
	
	public void tapOnFilter() {
		tapByElement(filter);
	}
	
	public void tapOnApplyBtn() {
		tapByElement(applyBtn);
	}

	public void scrollToPriceFilter() {
		swipeUpByElementHeightAndWidth(filterLayout, 1);
	}
	
	public void tapPriceFilterByName(String filterName) {
		WebElement filter = driver.findElement(AppiumBy.xpath(String.format("//*[@text='%s']", filterName)));
		tapByElement(filter);
	}
}
