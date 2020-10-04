package selenium.core.driver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() throws MalformedURLException {
        this.driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "--incognito",
                "--disable-extensions",
                "--disable-popup-blocking"
        );
        options.setCapability("browserName", "chrome");
        options.setCapability("platform", Platform.LINUX);
        return options;
    }
}
