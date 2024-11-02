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

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Tất cả']/..")
	private WebElement comboboxAll;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Cần Thơ']/..")
	private WebElement comboboxCanTho;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Tiếng Việt']/..")
	private WebElement comboboxVi;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Tiếng Anh']/..")
	private WebElement comboboxEn;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Tiếng Khmer']/..")
	private WebElement comboboxKh;
	
	@FindBy(how = How.XPATH, using = "//android.widget.Button")
	private WebElement continueButton;
	
	public void tapOnVi() {
		tapByElement(comboboxVi);
	}
	
	public void tapOnEn() {
		tapByElement(comboboxEn);
	}
	
	public void tapOnKh() {
		tapByElement(comboboxKh);
	}
	
	public void tapOnAll() {
		tapByElement(comboboxAll);
	}
	
	public void tapOnCanTho() {
		tapByElement(comboboxCanTho);
	}
	
	public void tapOnContinue() {
		tapByElement(continueButton);
	}
}
