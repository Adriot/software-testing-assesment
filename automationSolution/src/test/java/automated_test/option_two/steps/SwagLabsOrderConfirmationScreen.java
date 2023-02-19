package automated_test.option_two.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pom.automated_test.option_two.SwagLabsCheckoutCompletePage;

public class SwagLabsOrderConfirmationScreen extends SwagLabs {
    private Logger log  = LogManager.getLogger(SwagLabsOrderConfirmationScreen.class);
    @Then("^Confirm Order Confirmation Screen$")
    public void confirmOrderConfirmationScreen() {
        SwagLabsCheckoutCompletePage swagLabsCheckoutCompletePage = new SwagLabsCheckoutCompletePage(webDriver);
        boolean checkoutCompleteDisplayed = swagLabsCheckoutCompletePage
                .isCheckoutCompleteTextDisplayed("THANK YOU FOR YOUR ORDER");
        log.info("Checkout Complete Displayed: " + checkoutCompleteDisplayed);
        Assert.assertTrue(checkoutCompleteDisplayed);
    }

    @After
    public void cleanUp() {
        webDriver.quit();
        webDriver = null;
    }
}
