package core.selenium;

import static core.Utils.readBrowserAndVersionProperty;

import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserFactory {

  private final static String BROWSER = "props.browser.and.version";

  @RegisterExtension
  static SeleniumExtension seleniumJupiter = new SeleniumJupiter();

  public static WebDriver setUpBrowser(String browser, String version) {
    switch (browser) {
      case "chrome":
        seleniumJupiter.getConfig().chromedriver().driverVersion(version).setup();
        return new ChromeDriver(new ChromeOptions().addArguments("--start-maximized",
            "--incognito",
            "--disable-extensions",
            "--disable-popup-blocking"
        ));
      case "firefox":
        seleniumJupiter.getConfig().firefoxdriver().driverVersion(version).setup();
        return new FirefoxDriver(new FirefoxOptions());

      default:
        throw new RuntimeException(
            "No such browser. Acceptable browsers are: chrome, firefox");
    }
  }

  public static WebDriver setUpBrowser() {
    String[] values = readBrowserAndVersionProperty(BROWSER);
    String browser = values[0];
    String version = values[1];
    return setUpBrowser(browser, version);
  }

}
