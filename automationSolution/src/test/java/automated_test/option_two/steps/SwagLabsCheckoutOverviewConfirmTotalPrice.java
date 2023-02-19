package automated_test.option_two.steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pom.automated_test.option_two.SwagLabsCheckoutOverviewPage;

public class SwagLabsCheckoutOverviewConfirmTotalPrice extends SwagLabs {
    SwagLabsCheckoutOverviewPage swagLabsCheckoutOverviewPage = new SwagLabsCheckoutOverviewPage(webDriver);

    @Then("^Confirm Total Price On Checkout Overview Screen$")
    public void confirm_Total_Price_On_Checkout_Overview_Screen() {
        boolean totalCorrect = swagLabsCheckoutOverviewPage.isTotalCorrect(String.valueOf(pricesSum));
        Assert.assertTrue("Total is expected to be " + pricesSum, totalCorrect);
    }

    @Then("^Finish Order$")
    public void finish_Order() {
        swagLabsCheckoutOverviewPage.finish();
    }
}
