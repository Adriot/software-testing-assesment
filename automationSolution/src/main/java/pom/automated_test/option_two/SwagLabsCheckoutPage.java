package pom.automated_test.option_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.web.driver.SeleniumBase;
public class SwagLabsCheckoutPage extends SeleniumBase {
    private Logger log  = LogManager.getLogger(SwagLabsCheckoutPage.class);
    @FindBy(id = "first-name")
    private WebElement firstNameElement;

    @FindBy(id = "last-name")
    private WebElement lastNameElement;

    @FindBy(id = "postal-code")
    private WebElement postalCodeElement;

    @FindBy(id = "continue")
    private WebElement continueElement;

    public SwagLabsCheckoutPage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(firstNameElement));
    }

    public void completeCheckoutAndContinue(String firstName, String lastName, String postalCode) {
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        postalCodeElement.sendKeys(postalCode);
        continueElement.click();
    }
}
