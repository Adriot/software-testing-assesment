package automated_test.option_two.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.automated_test.option_two.SwagLabsProductsPage;

public class SwagLabsAddProductsToCart extends SwagLabs {
    private Logger log  = LogManager.getLogger(SwagLabsAddProductsToCart.class);
    SwagLabsProductsPage swagLabsProductsPage = new SwagLabsProductsPage(webDriver);

    @Given("^User Add Products \"([^\"]*)\" To Cart$")
    public void addProductsToCart(String products) {
        pricesSum = 0;
        String[] productsList = products.split(",");

        String price;
        for (String product : productsList) {
            price = swagLabsProductsPage.addItemToCart(product);
            System.out.println("returned priced: " + price);
            pricesSum += Double.parseDouble(price.replace("$", ""));
        }

        log.info("Total Price: " + pricesSum);
    }

    @When("^User goes to cart$")
    public void userGoesToCart() {
        swagLabsProductsPage.goToCart();
    }
}
