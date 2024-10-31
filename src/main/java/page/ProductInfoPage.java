package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductInfoPage extends BasePage {

	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productDetail2:id/button_add_to_cart")
	private WebElement addToCart;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productDetail2:id/button_buy_now")
	private WebElement buyNow;
	
	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productDetail2:id/button_other")
	private WebElement payLater;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc=\"pdp_product_name\"]")
	private WebElement productName;

	public ProductInfoPage(AndroidDriver androidDriver) {
		super(androidDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void tiltToAddToCart() {
		swipe(300, 1019, 300, 900, Duration.ofSeconds(3));
	}
	
	public void tapOnAddToCart() {
		tapByElement(addToCart);
		//tapByCoordinates(199, 1103);
	}
	
	public boolean isProductNameDisplay() {
		return isElementVisibility(productName);
	}
	
	public String getBtnAddToCartText() {
		return getText(addToCart);
	}
	
	public String getBtnBuyNowText() {
		return getText(buyNow);
	}
	
	public String getBtnPayLaterText() {
		return getText(payLater);
	}

}
