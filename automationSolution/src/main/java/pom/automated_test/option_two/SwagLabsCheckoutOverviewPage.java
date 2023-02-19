package pom.automated_test.option_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.web.driver.SeleniumBase;
public class SwagLabsCheckoutOverviewPage extends SeleniumBase {
    private Logger log  = LogManager.getLogger(SwagLabsCheckoutOverviewPage.class);
    @FindBy(className = "summary_subtotal_label")
    private WebElement summarySubtotalLabelElement;

    @FindBy(id = "finish")
    private WebElement finishElement;

    public SwagLabsCheckoutOverviewPage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(summarySubtotalLabelElement));
    }

    public boolean isTotalCorrect(String itemTotal) {
        String subtotal = summarySubtotalLabelElement.getText();
        if (subtotal.contains(itemTotal)) {
            return true;
        }
        return false;
    }

    public void finish() {
        finishElement.click();
    }
}
