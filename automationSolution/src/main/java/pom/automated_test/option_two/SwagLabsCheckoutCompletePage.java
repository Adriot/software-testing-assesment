package pom.automated_test.option_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.web.driver.SeleniumBase;
public class SwagLabsCheckoutCompletePage extends SeleniumBase {
    private Logger log  = LogManager.getLogger(SwagLabsCheckoutCompletePage.class);

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    private WebElement checkoutCompleteElement;

    public SwagLabsCheckoutCompletePage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(checkoutCompleteElement));
    }

    public boolean isCheckoutCompleteTextDisplayed(String expectedCheckoutCompleteText) {
        String checkoutCompleteText = checkoutCompleteElement.getText();
        if (checkoutCompleteText.equalsIgnoreCase(expectedCheckoutCompleteText)) {
            return true;
        }
        return false;
    }

}
