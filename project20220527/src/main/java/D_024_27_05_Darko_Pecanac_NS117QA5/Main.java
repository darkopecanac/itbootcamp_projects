/* DOMAĆI 27. 05. 2022, 1. ZADATAK:
 *
 * Otići na https://www.stealmylogin.com/demo.html,
 * uneti bilo koje kredencijale za login, prisisnuti dugme.
 *
 * Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje.
 * Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
 *
 * Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.
 * Kod na git, screen recording puštanja i izvršavanja testa na Drive.
 */

package D_024_27_05_Darko_Pecanac_NS117QA5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
//    driver.manage().window().maximize();

    driver.get("https://www.stealmylogin.com/demo.html");

    WebElement inputUsername = driver.findElement(By.name("username"));
    inputUsername.sendKeys("Test");
    WebElement inputPassword = driver.findElement(By.name("password"));
    inputPassword.sendKeys("test!");
    // WebElement loginButton = driver.findElement(By.xpath("/html/body/form/input[3]"));
    WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
    loginButton.click();

    String urlAfterLogin = driver.getCurrentUrl();

    if ( urlAfterLogin.equals("https://example.com/") )
      System.out.println("Nice!");
    else
      System.out.println("Not nice!");

    driver.close();
  }
}