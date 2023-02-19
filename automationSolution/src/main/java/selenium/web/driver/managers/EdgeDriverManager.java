package selenium.web.driver.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class EdgeDriverManager extends DriverManager {
    private Logger log  = LogManager.getLogger(EdgeDriverManager.class);
    @Override
    protected void createDriver() {
        WebDriverManager.edgedriver().version(version).setup();
        driver = new EdgeDriver();
    }

    protected void createDriver(String driverPathProperty) {
        String edgeDriverPath = properties.getProperty(driverPathProperty);
        File file = new File(edgeDriverPath);
        if (file.exists()) {
            System.setProperty("webdriver.edge.driver", edgeDriverPath);
            driver = new EdgeDriver();
        } else {
            log.error("Please update your driver path property");
        }
    }

    @Override
    protected void createDriver(boolean headless) {
        if (headless) {
            // TODO
        } else {
            createDriver();
        }
    }
}
