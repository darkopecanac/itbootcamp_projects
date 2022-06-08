/* RAD NA CASU, 31. 05. 2022. ZADATAK 4. (za vežbanje)
 *
 * Napisati program koji vrši dodavanje podataka u tabelu, čitajući podatke iz fajla.
 *        maksimizirati prozor
 *        učitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
 *        dodati red podataka - jedan red u jednoj iteraciji
 * kliknite na dugme Add New
 * unesite name, departmant i phone (mogu da budu uvek iste vrednost)
 * kliknite na zeleno Add dugme
 *        sacekati 5 sekundi
 *        obrisati sve podatke iz tabele
 *        na kraju programa ugasite pretraživač.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak04 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

    for ( int i = 1; i <= 5; i++ ) {
      driver.findElement(By.className("add-new")).click();
      driver.findElement(By.id("name")).sendKeys("Uros");
      driver.findElement(By.id("department")).sendKeys("JS");
      driver.findElement(By.id("phone")).sendKeys("065645565");
      driver.findElement(By.xpath(
              "//tbody/tr[last()]/td[4]/a[@class='add']")).click();
    }

    List<WebElement> rows = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

    for ( int i = 0; i < rows.size(); i++ ) {
      // Dodatno tr filtriramo na osnovu klase delete
      rows.get(i).findElement(By.className("delete")).click();
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}