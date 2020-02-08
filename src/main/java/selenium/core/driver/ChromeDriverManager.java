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
                new URL("http://127.0.0.1:4444/wd/hub"),
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
        options.setCapability("version","78.0.3904.70");
        return options;
    }
}
