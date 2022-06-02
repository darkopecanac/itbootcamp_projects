/* RAD NA CASU, 30. 05. 2022. ZADATAK 1.
 *
 * Napisati program koji nakon prijavljivanja na stranicu
 * http://cms.demo.katalon.com/my-account/
 * cekira "Remember me" checkbox.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak01 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.navigate().to("http://cms.demo.katalon.com/my-account/");

    WebElement rememberMeChk = driver.findElement(By.id("rememberme"));
    rememberMeChk.click();
  }
}