package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class AccountPage extends BasePage {

	@FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.myAccount:id/recyclerView")
	private WebElement recyclerView;
	
	@FindBy(how = How.XPATH, using = "//*[@resource-id='vn.tiki.app.tikiandroid.myAccount:id/osvViewed']/android.widget.TextView")
	private WebElement viewed;
	
	@FindBy(how = How.XPATH, using = "//*[@resource-id='vn.tiki.app.tikiandroid.myAccount:id/osvLove']/android.widget.TextView")
	private WebElement favorited;
	
	@FindBy(how = How.XPATH, using = "//*[@resource-id='vn.tiki.app.tikiandroid.myAccount:id/osvBuyAgain']/android.widget.TextView")
	private WebElement buyAgain;
	
	public AccountPage(AndroidDriver androidDriver) {
		super(androidDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void swipeToInterested() {
		swipeUpByElementHeightAndWidth(recyclerView, 1);
	}
	
	public String getViewedItemText() {
		return getText(viewed);
	}

	public String getFavoritedItemText() {
		return getText(favorited);
	}
	
	public String getBuyAgainItemText() {
		return getText(buyAgain);
	}
}
