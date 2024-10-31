package stepdefinitions;

import org.testng.Assert;

import core.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CategoryPage;
import page.HomePage;

public class CategoryPageStepDefinitions {
private CategoryPage categoryPage;
	
	public CategoryPageStepDefinitions() {
		categoryPage = new CategoryPage(BaseTest.getDriver());
	}
	
	@When("User click on {string}")
	public void user_click_on(String string) {
	    categoryPage.tapOnCategoryByName(string);
	}
	
	@Then("User should see the {string} on the right side")
	public void user_should_see_the_on_the_right_side(String string) {
	    Assert.assertEquals(string, categoryPage.getRightTitleText(), "Right Title does not match");
	}
	@Then("User should see the first section {string}")
	public void user_should_see_the_first_section(String string) {
		Assert.assertEquals(string, categoryPage.getFirstSectionText(), "First section text does not match");
	}
}
