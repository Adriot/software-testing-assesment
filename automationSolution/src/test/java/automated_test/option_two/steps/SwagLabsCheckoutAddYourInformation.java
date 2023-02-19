package automated_test.option_two.steps;

import cucumber.api.java.en.Then;
import pom.automated_test.option_two.SwagLabsCheckoutPage;

public class SwagLabsCheckoutAddYourInformation extends SwagLabs {
    @Then("^User Inputs Checkout Information \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void inputUserCheckoutInformation(String firstName, String lastName, String zipCode) {
        SwagLabsCheckoutPage swagLabsCheckoutPage = new SwagLabsCheckoutPage(webDriver);
        swagLabsCheckoutPage.completeCheckoutAndContinue(firstName, lastName, zipCode);
    }
}
