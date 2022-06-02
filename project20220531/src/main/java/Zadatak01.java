/* RAD NA CASU, 31. 05. 2022. ZADATAK 1.
 *
 * Testirati rad cookies-a na strani https://www.lambdatest.com/
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak01 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
  }
}