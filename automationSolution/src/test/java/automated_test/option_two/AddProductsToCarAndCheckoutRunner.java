package automated_test.option_two;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@AddProductsToCartAndCheckout"},
        features = {"src/test/resources/features"},
        glue = {"automated_test/option_two/steps"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/swaglabs/Add Products To Cart And Checkout.html",
        "json:target/cucumber.json"}
)

public class AddProductsToCarAndCheckoutRunner {
}
