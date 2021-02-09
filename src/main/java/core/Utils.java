package core;

import static java.util.Objects.isNull;

public class Utils {

  public static String[] readBrowserAndVersionProperty(String property) {
    String browserAndVersionProperty = System.getProperty(property);
    if (isNull(browserAndVersionProperty)) {
      throw new IllegalArgumentException("System property for browser and its version is required. E.g.:-Dprops.browser.and.version=firefox,73.0");
    }
    if (browserAndVersionProperty.split(",").length != 2) {
      throw new IllegalArgumentException("Make sure you provided browser and version in System property E.g.:-Dprops.browser.and.version=firefox,73.0");
    }
    return browserAndVersionProperty.split(",");

  }

}
