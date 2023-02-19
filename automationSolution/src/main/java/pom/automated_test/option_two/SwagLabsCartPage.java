package pom.automated_test.option_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.web.driver.SeleniumBase;

import java.util.List;

public class SwagLabsCartPage extends SeleniumBase {
    private Logger log  = LogManager.getLogger(SwagLabsCartPage.class);

    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartItemListElement;

    @FindBy(id = "checkout")
    private WebElement checkoutElement;

    public SwagLabsCartPage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(checkoutElement));
    }

    public boolean isItemOnCart(String itemName) {
        for (WebElement element : cartItemListElement) {
            if (itemName.equalsIgnoreCase(element.getText())) {
                log.info(element.getText() +" is on Cart");
                return true;
            }
        }
        return false;
    }

    public void checkOut() {
        checkoutElement.click();
    }
}
