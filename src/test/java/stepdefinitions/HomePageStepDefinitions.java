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
	
	@Given("User close popup banner")
	public void user_close_popup_banner() throws InterruptedException {
	    homePage.tapOnCloseBanner();
	}
	
	@Then("User should see feature section")
	public void user_should_see_feature_section() {
		Assert.assertTrue(homePage.isFeatureSectionDisplayed());
	}
	@Then("User should see associated hospital section")
	public void user_should_see_associated_hospital_section() {
		Assert.assertTrue(homePage.isAssociatedHospitalSectionDisplayed());
	}
	@Then("User should see banner section")
	public void user_should_see_banner_section() {
		Assert.assertTrue(homePage.isCarouselBannerDisplayed());
	}
	@Then("User should see recommended hospital section")
	public void user_should_see_recommended_hospital_section() {
		Assert.assertTrue(homePage.isRecommendHospitalSectionDisplayed());
	}
	@Then("User should see telemedicine doctor section")
	public void user_should_see_telemedicine_doctor_section() {
		Assert.assertTrue(homePage.isDoctorTelemedSectionDisplayed());
	}
	@Then("User should see comprehensive medical bundle section")
	public void user_should_see_comprehensive_medical_bundle_section() {
		Assert.assertTrue(homePage.isComprehensiveMedicalDisplayed());
	}
}
