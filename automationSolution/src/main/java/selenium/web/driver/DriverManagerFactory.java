package selenium.web.driver;

import files.FilePropertiesConfig;
import selenium.web.driver.managers.*;

import java.util.Properties;

public class DriverManagerFactory {
    public static DriverManager getDriverManager() {
        FilePropertiesConfig filePropertiesConfig = new FilePropertiesConfig();
        filePropertiesConfig.loadProperties();
        Properties properties = filePropertiesConfig.getProperties();
        DriverType driverType = DriverType.valueOf(properties.getProperty("DRIVER_TYPE"));
        return setupDriverManager(driverType);
    }

    public static DriverManager getDriverManager(DriverType driverType) {
        return setupDriverManager(driverType);
    }

    private static DriverManager setupDriverManager(DriverType driverType) {
        DriverManager driverManager;
        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            case OPERA:
                driverManager = new OperaDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case PHANTOMJS:
                driverManager = new PhantomJsDriverManager();
                break;
            case IEXPLORER:
                driverManager = new InternetExplorerDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
}
