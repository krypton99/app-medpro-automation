package stepdefinitions;

import org.testng.Assert;

import core.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

public class HomePageStepDefinitions {
	private HomePage homePage;
	
	public HomePageStepDefinitions() {
		homePage = new HomePage(BaseTest.getDriver());
	}
		
	@Given("User open Medpro application")
	public void user_open_medpro_application() {
	    System.out.println("Application opened successfully!");
	}
	
	@Then("User should see feature {string}")
	public void user_should_see_feature(String string) {
	    homePage.tapOnDoctor();
	}
}
