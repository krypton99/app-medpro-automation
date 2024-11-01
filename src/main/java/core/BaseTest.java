package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	private static AndroidDriver driver;
	private static UiAutomator2Options options;

	
	public static void setupDriver() throws MalformedURLException {
		options = new UiAutomator2Options().setDeviceName(Constants.DEVICE_NAME).setPlatformName(Constants.PLATFORM_NAME)
				.setPlatformVersion(Constants.PLATFORM_VERSION).setAppPackage(Constants.MEDPRO_APP_PKG)
				.setAppActivity(Constants.MEDPRO_MAIN_ACTIVITY).setAutomationName(Constants.AUTOMATION_NAME).setAutoGrantPermissions(true);
		driver = new AndroidDriver(new URL(Constants.APPIUM_URL), options);
	}

	
	public static void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}

	public static AndroidDriver getDriver() {
		return driver;
	}
}
