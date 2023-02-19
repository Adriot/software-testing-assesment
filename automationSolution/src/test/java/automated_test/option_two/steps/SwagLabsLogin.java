package automated_test.option_two.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pom.automated_test.option_two.SwagLabsLoginPage;
import pom.automated_test.option_two.SwagLabsProductsPage;

public class SwagLabsLogin extends SwagLabs {
    private Logger log  = LogManager.getLogger(SwagLabsLogin.class);
    @Given("^User navigate to the login page$")
    public void userNavigateToTheLoginPage() throws Throwable {
        webDriver.get("https://www.saucedemo.com/");
    }

    @When("^User submits username and password$")
    public void loginToSwagLabs() throws Throwable {
        String title = webDriver.getTitle();
        log.info("Title: " + title);

        SwagLabsLoginPage loginPage = new SwagLabsLoginPage(webDriver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("^User should be logged in$")
    public void iShouldBeLoggedIn() {
        SwagLabsProductsPage swagLabsProductsPage = new SwagLabsProductsPage(webDriver);
        Assert.assertTrue(swagLabsProductsPage.productsHeaderDisplayed());
    }
}
