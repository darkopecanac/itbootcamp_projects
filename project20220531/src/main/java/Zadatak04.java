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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak04 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
  }
}