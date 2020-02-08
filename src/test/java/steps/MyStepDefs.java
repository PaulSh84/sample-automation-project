package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import selenium.core.driver.BrowserType;
import selenium.core.driver.DriverManager;
import selenium.core.driver.DriverManagerFactory;

import java.net.MalformedURLException;

public class MyStepDefs {
    DriverManagerFactory factory;
    WebDriver driver;

    @Before
    public void before() throws MalformedURLException {
        DriverManager driverManager = new DriverManagerFactory().getDriverManager(BrowserType.CHROME);
        driver = driverManager.getDriver();
    }

    @Given("Google page is opened")
    public void openGooglePage() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(20000);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
