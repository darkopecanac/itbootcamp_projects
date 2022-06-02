/*
 *
 * Napisati dva smoke testa za https://www.telerik.com/support/demos:
 *        - Proveriti da klikom na Desktop odlazimo na tu sekciju
 *        - Proveriti da klikom na Mobile odlazimo na tu sekciju
 * Koristiti TestNG, asserte.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class D_026_31_05_Darko_Pecanac_NS117QA5 {

  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();

    driver.navigate().to("https://www.telerik.com/support/demos");
    driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
    driver.close();
  }

  @Test
  public void testDesktopSection() {
    try {
      WebElement webElementDesktop = driver.findElement(By.cssSelector("a[href='#desktop']"));
      webElementDesktop.click();

      Thread.sleep(8000);

      Assert.assertTrue(webElementDesktop.getAttribute("class").contains("is-active"));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testMobileSection() {
    try {
      driver.navigate().refresh();

      WebElement webElementMobile = driver.findElement(By.cssSelector("a[href='#mobile']"));
      webElementMobile.click();

      Thread.sleep(8000);

      Assert.assertTrue(webElementMobile.getAttribute("class").contains("is-active"));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}