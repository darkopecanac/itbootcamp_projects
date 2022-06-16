package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private static final String HOME_PAGE_URL = "https://computer-database.gatling.io/computers";
  private static final String NEW_COMP_PAGE_URL = "https://computer-database.gatling.io/computers/new";

  private WebDriver webDriver;
  private WebDriverWait webDriverWait;

  public BasePage(WebDriver webDriver, WebDriverWait webDriverWait) {

    this.webDriver = webDriver;
    this.webDriverWait = webDriverWait;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }
  public void setWebDriver(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public WebDriverWait getWebDriverWait() {
    return webDriverWait;
  }
  public void setWebDriverWait(WebDriverWait webDriverWait) {
    this.webDriverWait = webDriverWait;
  }

  public void openHomePage() {
    webDriver.navigate().to(HOME_PAGE_URL);
  }

  public void openNewCompPage() {
    webDriver.navigate().to(NEW_COMP_PAGE_URL);
  }
}