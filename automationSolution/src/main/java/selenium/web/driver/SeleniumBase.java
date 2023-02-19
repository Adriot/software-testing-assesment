package selenium.web.driver;

import files.FilePropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class SeleniumBase {
    private WebDriver webDriver;
    protected static WebDriverWait wait;

    public SeleniumBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);

        FilePropertiesConfig filePropertiesConfig = new FilePropertiesConfig();
        filePropertiesConfig.loadProperties();
        Properties properties = filePropertiesConfig.getProperties();
        long driverWaitPeriod = Long.parseLong(properties.getProperty("DRIVER_WAIT_PERIOD"));

        this.wait = new WebDriverWait(webDriver, driverWaitPeriod);
    }
}
