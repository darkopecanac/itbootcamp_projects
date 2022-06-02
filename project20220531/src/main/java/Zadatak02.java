/* RAD NA CASU, 31. 05. 2022. ZADATAK 2.
 *
 * Napisati program koji učitava stranicu
 * https://crop-circle.imageonline.co/#circlecropresult
 * i upload-ujte sliku na sajt.
 *
 * Kliknite na dugme Crop Circle i preuzeti korigovanu sliku
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak02 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
  }
}