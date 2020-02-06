package selenium.core.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(""))
                .usingAnyFreePort()
                .build();
//        this.driver = service;


    }

//    private DesiredCapabilities getChromeCapabilities() {
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        return capabilities;
//    }
}
