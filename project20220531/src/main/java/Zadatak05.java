/* RAD NA CASU, 31. 05. 2022. ZADATAK 4. (za vežbanje)
 *
 * Napisati program koji učitava stranicu https://cms.demo.katalon.com/ i:
 * •	proverava da li je naslov na stranici jednak Shop
 * •	proverava da li postoji poruka Showing 1–12 of 24 results
 * •	proverava da li strana prikazuje 12 proizvoda
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Zadatak05 {

  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
  }

  @BeforeMethod
  public void beforeMehtod() {
    driver.navigate().to("https://cms.demo.katalon.com/");
//    driver.navigate().refresh();
  }

  @AfterClass
  public void afterClass() {
    driver.close();
  }

  @Test
  public void testHeaderTitle() {
    WebElement headerElement = driver.findElement(By.xpath(
            "//*[@id=\"page\"]/header/h1"));
    String expectedTitle = "Shop";
    String actualTitle = headerElement.getText();
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  @Test
  public void testCountMessage() {
    WebElement countMessageElement = driver.findElement(By.xpath(
            "//*[@id=\"main\"]/p"));
    String actualCountMessage = countMessageElement.getText();
    String expectedCountMessage = "Showing 1–12 of 24 results";
    Assert.assertEquals(actualCountMessage, expectedCountMessage);
  }

  @Test
  public void testCountProduct() {
    List<WebElement> count = driver.findElements(By.xpath(
            "//*[@id=\"main\"]/div[2]/ul/li"));
    Assert.assertEquals(12, count.size());
  }
}