/* RAD NA CASU, 27. 05. 2022. ZADATAK 4.
 *
 * Sa stranice https://www.w3schools.com/sql/
 * nađite xpath koji hvata sve linkove iz glavne navigacije.
 * To su: HTML, CSS, JAVASCRIPT, SQL, PYTHON, ...
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak04a {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://www.w3schools.com/sql/");

//    "//a[contains(@class, 'w3-bar-item')]"
//    "//*[@id="topnav"]/div/div[1]"

    List<WebElement> elementList = driver.findElements(By.xpath(
            "//*[@id='topnav']/div/div[1]/a[contains(@class, 'w3-bar-item')]"));

//    "//div[not(@class = 'item')]"

    for ( WebElement element : elementList ) {
      System.out.println(element.getText());
    }
  }
}