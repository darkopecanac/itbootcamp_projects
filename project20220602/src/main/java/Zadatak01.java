/* RAD NA CASU, 02. 06. 2022. ZADATAK 2. (za vežbanje)
 *
 * Napisati program koji:
 * ·        učitava stranicu https://cms.demo.katalon.com/
 * ·        dodaje prva 3 proizvoda u korpu
 * ·        klikne na Cart link iz navigacije i
 * ·        proverava da na stranici postoji 3 proizvoda
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Zadatak01 {

  private WebDriver driver;

  @BeforeClass
  public void setUp() {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() {

    driver.navigate().to("https://cms.demo.katalon.com/");
  }

  @Test
  public void testNumberOfItemsInCart() {

    try {
      List<WebElement> elementsForCart = driver.findElements(By.className("add_to_cart_button"));
      // List<WebElement> elementsForCart = driver.findElements(By.className("product"));

      for ( int i = 0; i < 3; i++ ) {
        elementsForCart.get(i).click();
      }

      Thread.sleep(1000);
      driver.findElement(By.xpath(
              "//*[@id=\"primary-menu\"]/ul/li[1]/a")).click();

      List<WebElement> elementsInCart = driver.findElements(By.className("remove"));

      int expected = 3;
      int actual = elementsInCart.size();

      Assert.assertEquals(actual, expected);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
  }
}