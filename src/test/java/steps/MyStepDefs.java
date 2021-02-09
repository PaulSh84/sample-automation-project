package steps;

import core.selenium.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class MyStepDefs {

  WebDriver driver;

  @Before
  public void setUpDriver() {
    driver = BrowserFactory.setUpBrowser();
  }

  @Given("Google page is opened")
  public void openGooglePage() throws InterruptedException {
    driver.get("https://www.google.com/");
    Thread.sleep(5000);
  }


  @After
  public void tearDownChrome() {
    driver.manage().deleteAllCookies();
    driver.quit();
  }
}
