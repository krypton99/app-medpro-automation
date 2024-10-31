package stepdefinitions;

import org.testng.Assert;

import core.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ProductInfoPage;

public class ProductInfoPageStepDefinitions {
	private ProductInfoPage productInfoPage;
	
	public ProductInfoPageStepDefinitions() {
		productInfoPage = new ProductInfoPage(BaseTest.getDriver());
	}
	
	@Then("User should see button {string}")
	public void user_should_see_button(String string) {
	   if(string.equals(productInfoPage.getBtnAddToCartText())) Assert.assertTrue(true);
	   if(string.equals(productInfoPage.getBtnBuyNowText())) Assert.assertTrue(true);
	   if(string.equals(productInfoPage.getBtnPayLaterText())) Assert.assertTrue(true);
	}
}
