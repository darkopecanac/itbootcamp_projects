/* RAD NA CASU, 27. 05. 2022. ZADATAK 3.
 *
 * Napisati program koji:
 * - učitava stranicu https://demoqa.com/login
 * - čita naslov stranice i štampa ga na ekranu
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak03 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.get("https://demoqa.com/login");
    System.out.println(driver.getTitle());
  }
}