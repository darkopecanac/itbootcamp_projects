/* RAD NA CASU, 27. 05. 2022. ZADATAK 1.
 *
 * Posetiti stranicu http://cms.demo.katalon.com/
 * u delu za pretragu uneti tekst “Flying Ninja”,
 * i kliknuti na search dugme (search ikonica).
 * Pri učitavanju stranice maksimizovati prozor.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak01 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

//    driver.get("http://cms.demo.katalon.com/");
//    driver.get("http://www.google.com");
//    driver.get("http://www.youtube.com");

    driver.navigate().to("http://cms.demo.katalon.com/");
//    driver.navigate().to("http://www.google.com");
//    driver.navigate().forward();

//    WebElement element = driver.findElement(By.xpath("//*[@id=\"search-2\"]/form/label/input"));
    WebElement element = driver.findElement(By.name("s"));
    element.sendKeys("Flying Ninja");

    driver.findElement(By.className("search-submit")).click();
  }
}