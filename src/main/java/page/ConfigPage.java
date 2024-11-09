package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class ConfigPage extends BasePage {

	public ConfigPage(AndroidDriver androidDriver) {
		super(androidDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Tiếng Việt']/..")
	private WebElement comboboxVi;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Tiếng Anh']/..")
	private WebElement comboboxEn;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Tiếng Khmer']/..")
	private WebElement comboboxKh;
	
	public void tapOnVi() {
		tapByElement(comboboxVi);
	}
	
	public void tapOnEn() {
		tapByElement(comboboxEn);
	}
	
	public void tapOnKh() {
		tapByElement(comboboxKh);
	}
	
}
