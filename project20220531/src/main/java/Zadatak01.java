/* RAD NA CASU, 31. 05. 2022. ZADATAK 1.
 *
 * Testirati rad cookies-a na strani https://www.lambdatest.com/
 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Zadatak01 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.navigate().to("https://www.lambdatest.com/");

    Set<Cookie> cookies = driver.manage().getCookies();

    for ( Cookie cookie : cookies )
      System.out.println(cookie.getName() + " " + cookie.getValue());

    Cookie cookie = new Cookie("productId", "125454454545");
    driver.manage().addCookie(cookie);

//    Thread.sleep(10000);

    driver.manage().deleteCookie(cookie);
    driver.manage().deleteAllCookies();

  }
}