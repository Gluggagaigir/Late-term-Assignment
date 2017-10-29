package is.ru.hugb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class SeleniumTestWrapper {
  static ChromeDriver driver;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser() {
    System.setProperty("webdriver.chrome.driver", "src/selenium/webdriver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    port = System.getenv("PORT");
    if (port == null) {
        port = "4567";
    }
    baseUrl = "http://gluggagaigir-staging.herokuapp.com";
  }

  @AfterClass
  public static void closeBrowser(){
    driver.quit();
  }
}