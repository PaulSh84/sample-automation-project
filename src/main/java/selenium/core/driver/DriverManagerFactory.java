package selenium.core.driver;

public class DriverManagerFactory {


    public DriverManager getDriverManager(BrowserType type) {
        DriverManager driverManager = null;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;

            case FIREFOX:
                break;

            default:
                System.out.println("No driver is selected");
                break;
        }
        return driverManager;
    }
}
