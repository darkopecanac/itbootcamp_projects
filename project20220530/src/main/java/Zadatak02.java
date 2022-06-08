/* RAD NA CASU, 30. 05. 2022. ZADATAK 2.
 *
 * Napisati program koji ucitava stranicu
 *    https://www.ebay.com/
 * i bira kategoriju “Crafts”.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak02 {

  public static void main(String[] args) {

    try {
      System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();

      driver.navigate().to("http://www.ebay.com/");

      Select selectCategory = new Select(driver.findElement(By.id("gh-cat")));

      Thread.sleep(5000);

      selectCategory.selectByVisibleText("Crafts");

      Thread.sleep(5000);

      selectCategory.selectByVisibleText("Art");

      WebElement searchInput = driver.findElement(By.id("gh-ac"));
      searchInput.sendKeys("Aquarel");

      WebElement searchButton = driver.findElement(By.id("gh-btn"));
      searchButton.click();

      Thread.sleep(5000);
    } catch ( InterruptedException ex ) {
      ex.printStackTrace();
    }
  }
}