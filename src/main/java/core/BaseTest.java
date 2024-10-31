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
		options = new UiAutomator2Options().setDeviceName("samsung SM-S908E").setPlatformName("Android")
				.setPlatformVersion("9").setAppPackage("vn.com.medpro")
				.setAppActivity("vn.com.medpro.MainActivity").setAutomationName("UiAutomator2").setAutoGrantPermissions(true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
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
