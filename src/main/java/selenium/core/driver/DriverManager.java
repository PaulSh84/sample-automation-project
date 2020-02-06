package selenium.core.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;


public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createWebDriver() throws MalformedURLException;

    public void quitWebDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() throws MalformedURLException {
        if (driver == null)
            createWebDriver();
        return driver;
    }
}
