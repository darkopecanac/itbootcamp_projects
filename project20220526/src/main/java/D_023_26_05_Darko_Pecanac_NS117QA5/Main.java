/* DOMAĆI 26. 05. 2022, 1. ZADATAK:
 *
 * Otići na kupujemprodajem.com,
 * u pretragu ukucati "iphone 13",
 * kliknuti na prvi rezultat.
 *
 * Proveriti da je naslov oglasa onaj koji smo uočili i tokom manuelnog izvođenja kejsa.
 */

package D_023_26_05_Darko_Pecanac_NS117QA5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
  public static void main(String[] args) {
    try {
      // dp: Otvaranje Chrome pretrazivaca i uvecanje prozora.
      System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                         "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      // dp: Odlazak na trazenu stranicu, unos termina za pretragu i prikaz rezultata pretrage.
      driver.get("http://www.kupujemprodajem.rs");
      WebElement el = driver.findElement(By.id("searchKeywordsInput"));
      el.sendKeys("iphone 13");
      el.submit();

      // dp: Zatvaranje pop-up prozora (posto ponekad smeta, a ponekad ne, za dalji rad
      driver.findElement(By.xpath("/html/body/div[9]/div/div[2]")).click();
      Thread.sleep(5000);

      // dp: Odlazak na stranicu prvog rezultat pretrage (a da nije reklama), koji je oglas (u ovom slucaju zlatni).
      WebElement el1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div[5]/div/div[3]/a"));
      el1.click();

      // dp: Postavljanje naslova stranice uocenog tokom manuelnog testa i tokom automatskog testa.
      String expected = "iPhone 13, iPhone 12, iPhone 11 - NOVO! - KupujemProdajem";
      String title = driver.getTitle();

      // dp: Stranica se ponekad ne ucita kako treba, ovo je sluzilo za proveru.
      // System.out.println("Ocekivani naslov je: " + expected);
      // System.out.println("Naslov prozora je: " + title);

      // dp: Provera jednakosti naslova.
      if ( title.equals(expected) )
        System.out.println("Naslov je isti!");
      else
        System.out.println("Naslovi se razlikuju!");

      Thread.sleep(5000);
      driver.close();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}