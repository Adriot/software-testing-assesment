package automated_test.option_two.steps;

import files.FilePropertiesConfig;
import org.openqa.selenium.WebDriver;
import selenium.web.driver.DriverManagerFactory;
import selenium.web.driver.managers.DriverManager;

import java.util.Properties;

public class SwagLabs {
    static WebDriver webDriver;
    static double pricesSum = 0;

    public SwagLabs() {
        if (webDriver == null) {
            FilePropertiesConfig filePropertiesConfig = new FilePropertiesConfig();
            filePropertiesConfig.loadProperties();
            Properties properties = filePropertiesConfig.getProperties();

            DriverManager driverManager = DriverManagerFactory.getDriverManager();

            if (properties.getProperty("DRIVER_MANAGER").equalsIgnoreCase("YES")) {
                webDriver = driverManager.getWebDriver(true);
            } else {
                webDriver = driverManager.getWebDriver("EDGE_DRIVER_PATH");
            }
        }
    }
}
