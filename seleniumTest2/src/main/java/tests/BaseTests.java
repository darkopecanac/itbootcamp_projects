package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;
import pages.NewComputerPage;

import java.time.Duration;

public class BaseTests {

  private static final String HOME_URL = "https://computer-database.gatling.io/computers";

  private WebDriver webDriver;
  private WebDriverWait webDriverWait;

  private HomePage homePage;
  private NewComputerPage newComputerPage;

  @BeforeClass
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    webDriver = new ChromeDriver();

    webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    webDriver.navigate().to(HOME_URL);
    webDriver.manage().window().maximize();

    this.homePage = new HomePage(webDriver, webDriverWait);
    this.newComputerPage = new NewComputerPage(webDriver, webDriverWait);
  }

//  @AfterClass
//  public void afterClass() {
//    webDriver.close();
//  }


  public HomePage getHomePage() {
    return homePage;
  }

  public NewComputerPage getNewComputerPage() {
    return newComputerPage;
  }
}
