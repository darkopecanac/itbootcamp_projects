/* RAD NA CASU, 30. 05. 2022. ZADATAK 4b. FLUENT WAIT
 *
 * Napisati program koji ucitava stranicu
 *    https://s.bootsnipp.com/iframe/klDWV
 * i ceka da se ucita progress bar na 100%,
 * a zatim ispisuje tekst u konzoli “Stranica ucitana!”
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Zadatak04b {

  public static void main(String[] args) {

    // FLUENT WAIT:
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.navigate().to("https://s.bootsnipp.com/iframe/klDWV");

    Wait<WebDriver> waitDriver = new FluentWait<>(driver)
                                        .withTimeout(Duration.ofSeconds(50))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchFieldException.class);

    waitDriver.until(ExpectedConditions.textToBePresentInElementLocated(By.id("precent"), "100%"));
    System.out.println("Stranica je ucitana!");
  }
}