package stepdefinitions;

import core.BaseTest;
import io.cucumber.java.en.Given;
import page.ConfigPage;

public class ConfigPageStepDefinitions {
	private ConfigPage configPage;
	
	public ConfigPageStepDefinitions() {
		configPage = new ConfigPage(BaseTest.getDriver());
	}

	@Given("User choose language {string}")
	public void user_choose_language(String language) {
		switch (language) {
	    case "vietnamese": 
	    	configPage.tapOnVi();
    		break;
	    case "khmer": 
	    	configPage.tapOnKh();
    		break;
    	case "english":
    		configPage.tapOnEn();
    		break;
		}
	}

}
