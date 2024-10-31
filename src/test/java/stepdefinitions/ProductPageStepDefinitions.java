package stepdefinitions;

import core.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.ProductsPage;

public class ProductPageStepDefinitions {
private ProductsPage productsPage;
	
	public ProductPageStepDefinitions() {
		productsPage = new ProductsPage(BaseTest.getDriver());
	}
	
	@When("User click on the first product")
	public void user_click_on_the_first_product() {
		productsPage.isFilterDisplay();
	    productsPage.tapOnProductByIndex(0);
	}
	

}
