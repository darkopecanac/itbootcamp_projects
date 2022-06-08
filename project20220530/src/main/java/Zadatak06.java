/* RAD NA CASU, 30. 05. 2022. ZADATAK 6. (za vežbanje)
 *
 * Napisti program koji:
 *
 * Ucitava stranicu http://cms.demo.katalon.com/
 * Hvata sve linkove (Cart, Checkout, My Account, Sample Page, …) iz navigacije
 * i vraca listu WebElemenata
 * i ispisuje u konzoli tekst svakog linka
 *
 * Rezultat programa treba da bude:
 *
 * https://cms.demo.katalon.com/cart/
 * https://cms.demo.katalon.com/checkout/
 * https://cms.demo.katalon.com/my-account/
 * https://cms.demo.katalon.com/sample-page/
 * https://cms.demo.katalon.com/
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak06 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("http://cms.demo.katalon.com/");

//    ArrayList<String> webElements = new ArrayList<>();
//
//    for ( int i = 1; i <= 5; i++) {
//      WebElement linkText = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/ul/li[" + i + "]/a"));
//      String value = linkText.getAttribute("href");
//      webElements.add(value);
//    }
//
//    for ( String webElement : webElements ) {
//      System.out.println(webElement);
//    }

    List<WebElement> webElements = driver.findElements(By.xpath(
            "//*[@id=\"primary-menu\"]/ul/li/a"));

    for ( WebElement webElement : webElements ) {
      System.out.println(webElement.getAttribute("href"));
    }
  }
}