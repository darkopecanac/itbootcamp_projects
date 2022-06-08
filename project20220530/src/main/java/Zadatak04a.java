/* RAD NA CASU, 30. 05. 2022. ZADATAK 4a.
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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak04a {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10) );

    driver.navigate().to("https://s.bootsnipp.com/iframe/klDWV");

    driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("precent"), "100%"));

    System.out.println("Stranica ucitana!");

//        WebElement element = driver.findElement(By.id("precent"));
//        System.out.println(element.getText());
//        if(element.getText().equals("100%")){
//            System.out.println("Stranica je ucitana!");
//        }
  }
}