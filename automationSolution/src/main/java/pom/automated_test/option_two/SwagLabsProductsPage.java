package pom.automated_test.option_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.web.driver.SeleniumBase;

import java.util.List;
public class SwagLabsProductsPage extends SeleniumBase {
    private Logger log  = LogManager.getLogger(SwagLabsProductsPage.class);
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement productsHeader;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div")
    private List<WebElement> productsListElement;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement shoppingCartElement;

    public SwagLabsProductsPage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(productsHeader));
    }

    public boolean productsHeaderDisplayed() {
        if (productsHeader.isDisplayed() && (productsHeader.getText().equalsIgnoreCase("Products"))) {
            return true;
        }
        return false;
    }

    public String addItemToCart(String itemName) {
        for (WebElement element : productsListElement) {
            try {
                WebElement inventoryItemNameElement = element.findElement(By.className("inventory_item_name"));
                String inventoryItemName = inventoryItemNameElement.getText();
                if (inventoryItemName.equalsIgnoreCase(itemName)) {
                    WebElement addToCartElement = element.findElement(By.cssSelector("*[class=\"btn btn_primary btn_small btn_inventory\"]"));
                    WebElement priceElement = element.findElement(By.className("inventory_item_price"));
                    addToCartElement.click();
                    String price = priceElement.getText();
                    log.info(inventoryItemName + "=> Price: " + price);
                    return price;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void goToCart() {
        shoppingCartElement.click();
    }
}
