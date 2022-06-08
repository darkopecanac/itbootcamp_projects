/* RAD NA CASU, 30. 05. 2022. ZADATAK 7. (za vežbanje)
 *
 * Ucitava stranicu https://demoqa.com/login
 * Loguje se sa username itbootcamp i lozinkom ITBootcamp2021!
 * Zatim ceka do maksimalno 5 sekundi da se korisnik uloguje
 *
 * Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout.
 * Ispisati odgovarajucu poruku u konzoli za rezultat logovanja.
 * Klikne na dugme za logout
 * Gasi stranicu
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak07 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://demoqa.com/login");

    WebElement inputUsername = driver.findElement(By.id("userName"));
    inputUsername.sendKeys("itbootcamp");
    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys("ITBootcamp2021!");
    WebElement loginBtn = driver.findElement(By.id("login"));
    loginBtn.click();

    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    driverWait.until(ExpectedConditions.textToBePresentInElementLocated(
            By.id("submit"), "Log out"));
    System.out.println("Korisnik se ulogovao!");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.id("submit")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.close();
  }
}