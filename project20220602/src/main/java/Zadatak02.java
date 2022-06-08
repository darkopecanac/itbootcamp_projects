/* RAD NA CASU, 02. 06. 2022. ZADATAK 2. (za vežbanje)
 *
 * Napisati program koji:
 * ·        učitava stranu http://automationpractice.com/
 * ·        dodaje jedan proizvod i proverava da li se pojavio dijalog za Proceed to checkout
 * ·        klikne na dugme dresses i bira kategoriju Casual Dresses, i proverava da li se pojavljuje jedan proizvod
 */

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Zadatak02 {

  private WebDriver driver;
  private WebDriverWait wait;
  private Actions actions;

  @BeforeClass
  public void setUp() {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    actions = new Actions(driver);
  }

  @AfterClass
  public void afterClass() {

//    driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() {

    driver.get("http://automationpractice.com/");
  }

  @Test
  public void testProceedToCheckoutDialog() {

    actions.moveToElement(driver.findElement(By.xpath(
            "//*[@id=\"homefeatured\"]/li[1]"))).perform();

    WebElement addToCart = driver.findElement(By.xpath(
            "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
    addToCart.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));

    WebElement proceedBtn = driver.findElement(By.xpath(
            "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
    WebElement proceedBtnSpan = driver.findElement(By.xpath(
            "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));

    String proceedText = proceedBtn.getAttribute("title");
    System.out.println(proceedBtnSpan.getText());

    Assert.assertEquals("Proceed to checkout", proceedText);
    Assert.assertEquals("Proceed to checkout", proceedBtnSpan.getText());
  }

  @Test
  public void testCasualDressCategory() throws InterruptedException {

    WebElement linkElement = driver.findElement(By.xpath(
            "//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
    linkElement.click();

//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollBy(0,550)", "");

    actions.moveToElement(driver.findElement(By.xpath(
            "//*[@id=\"ul_layered_category_0\"]/li[1]"))).click().perform();

    Thread.sleep(5000);

    List<WebElement> productList = driver.findElements(By.className("product_list"));
    WebElement productCountInfo = driver.findElement(By.className("product-count"));

    Assert.assertEquals(1, productList.size());
    Assert.assertEquals("Showing 1 - 1 of 1 items", productCountInfo.getText());
  }
}