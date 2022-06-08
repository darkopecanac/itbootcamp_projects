/* RAD NA CASU, 30. 05. 2022. ZADATAK 3.
 *
 * Napisti program koji
 *    učitava stranicu https://www.w3schools.com/html/default.asp
 *    zatim klinke na Next dugme 5 puta.
 *
 * Za sve akcije na strani, čekamo najviše 2 sekunde.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak03 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    driver.navigate().to("https://www.w3schools.com/html/default.asp");

    //*[@id="main"]/div[2]/a[2]

    for ( int i = 0; i < 5; i++ ) {
      WebElement nextBtn = driver.findElement(By.cssSelector(
              "#main > div:nth-child(3) > a.w3-right.w3-btn"));
      nextBtn.click();
    }
  }
}