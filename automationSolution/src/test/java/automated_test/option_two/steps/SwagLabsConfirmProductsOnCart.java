package automated_test.option_two.steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pom.automated_test.option_two.SwagLabsCartPage;

public class SwagLabsConfirmProductsOnCart extends SwagLabs {
    @Then("^Confirm Correct Products \"([^\"]*)\" Are Added To Cart$")
    public void confirmCorrectProductsAreAddedToCart(String products) {
        SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(webDriver);

        String[] productsList = products.split(",");

        for (String product : productsList) {
            Assert.assertTrue((swagLabsCartPage.isItemOnCart(product)));
        }

        swagLabsCartPage.checkOut();
    }
}
