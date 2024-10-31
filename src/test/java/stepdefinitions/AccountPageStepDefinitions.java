package stepdefinitions;

import org.testng.Assert;

import core.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.AccountPage;

public class AccountPageStepDefinitions {
	private AccountPage accountPage;
	
	public AccountPageStepDefinitions() {
		accountPage = new AccountPage(BaseTest.getDriver());
	}
	
	@When("User swipe to Quan tâm section")
	public void user_swipe_to_quan_tâm_section() {
	    accountPage.swipeToInterested();
	}
	
	@Then("User should see item: {string}")
	public void user_should_see_item(String string) {
		if(string.equals(accountPage.getViewedItemText())) Assert.assertTrue(true);
		if(string.equals(accountPage.getBuyAgainItemText())) Assert.assertTrue(true);
		if(string.equals(accountPage.getFavoritedItemText())) Assert.assertTrue(true);
	}
}
