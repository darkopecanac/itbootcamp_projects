/* RAD NA CASU, 30. 05. 2022. ZADATAK 3.
 *
 * Napisti program koji
 *    učitava stranicu https://www.w3schools.com/html/default.asp
 *    zatim klinke na Next dugme 5 puta.
 *
 * Za sve akcije na strani, čekamo najviše 2 sekunde.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak03 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
  }
}
