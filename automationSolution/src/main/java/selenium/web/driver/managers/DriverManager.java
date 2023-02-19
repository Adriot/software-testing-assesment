package selenium.web.driver.managers;

import files.FilePropertiesConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;

public abstract class DriverManager {
    private Logger log = LogManager.getLogger(DriverManager.class);
    protected WebDriver driver;
    protected String version;
    protected DesiredCapabilities desiredCapabilities;
    protected Properties properties;

    public DriverManager() {
        try {
            FilePropertiesConfig filePropertiesConfig = new FilePropertiesConfig();
            filePropertiesConfig.loadProperties();
            properties = filePropertiesConfig.getProperties();
            version = properties.getProperty("DRIVER_VERSION");
        } catch (Exception e) {
            log.error("Error while loading DRIVER_VERSION");
        }
    }

    protected abstract void createDriver();

    protected abstract void createDriver(boolean headless);

    protected abstract void createDriver(String driverPathProperty);

    public WebDriver getWebDriver(boolean headless) {
        if (driver == null) {
            createDriver(headless);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getWebDriver(String driverPathProperty) {
        if (driver == null) {
            createDriver(driverPathProperty);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
