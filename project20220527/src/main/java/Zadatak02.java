/* RAD NA CASU, 27. 05. 2022. ZADATAK 2.
 *
 * Napisati program koji:
 * - učitava stranicu https://demoqa.com/login
 * - loginuje se sa usename-om itbootcamp i lozinkom ITBootcamp2021!
 * - zatim čeka 5 sekundi da se korisnik uloguje
 * - klikne na dugme za logout
 * - Gasi google chrome
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak02 {

  public static void main(String[] args) {

    try {
      System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.navigate().to("https://demoqa.com/login");

      driver.findElement(By.id("userName")).sendKeys("itbootcamp");

      WebElement inputPassword = driver.findElement(By.id("password"));
      inputPassword.sendKeys("darko");
      inputPassword.clear();
      inputPassword.sendKeys("ITBootcamp2021!");
      inputPassword.sendKeys(Keys.ENTER);

      Thread.sleep(5000);
//      driver.findElement(By.id("login")).click();

      WebElement btnLogout = driver.findElement(By.id("submit"));
      btnLogout.click();

      Thread.sleep(3000);

      driver.close();
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
  }
}