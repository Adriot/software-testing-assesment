package pom.automated_test.option_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.web.driver.SeleniumBase;
public class SwagLabsLoginPage extends SeleniumBase {
    private Logger log  = LogManager.getLogger(SwagLabsLoginPage.class);
    @FindBy(id = "user-name")
    private WebElement userNameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "login-button")
    private WebElement loginButtonElement;

    public SwagLabsLoginPage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(userNameElement));
    }

    public void login(String username, String password) {
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }
}
