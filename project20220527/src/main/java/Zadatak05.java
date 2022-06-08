/* RAD NA CASU, 27. 05. 2022. ZADATAK 5.
 *
 * Napisati program koji:
 * - učitava stranicu https://www.w3schools.com/html/default.asp
 * - i za svaki element iz navigacije (Tutorials, References, Exercises) radi:
 *        - klik na element
 *        - čeka se 1s
 *        - klikne se opet na isti element
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak05 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    // Nije zavrsen!
    driver.get("https://www.w3schools.com/html/default.asp");
    //      //*[@id="pagetop"]
    //        "//a[contains(@class, 'w3-bar-item')]"
    List<WebElement> elementList = driver.findElements(By.xpath(
            "//*[@id='pagetop']/a[contains(@class, 'w3-bar-item')]"));

    for(WebElement element : elementList){
      System.out.println(element.getText());
    }
  }
}