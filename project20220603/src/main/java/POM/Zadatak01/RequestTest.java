/* RAD NA CASU, 03. 06. 2022. ZADATAK 1. (za vežbanje)
 *
 * Napisati program koji testira funkcionalnost dodavanja prijatelja na društvenoj mreži.
 *
 * Od klasa je potrebno:
 *    POM.Zadatak01.BasePage – dodati neophodne metode
 *    POM.Zadatak01.LoginPage – dodati neophodne metode
 *    POM.Zadatak01.FriendPage – dodati neophodne metode
 *    POM.Zadatak01.RequestTest koja:
          - Ucitava stranicu https://demo.opensource-socialnetwork.org/login
 *        - Prijavljuje se na sajt koristeci podatke administrator/administrator
 *        - Ucitava jednu od stranica:
 *            https://demo.opensource-socialnetwork.org/u/Keyshawn89
 *            https://demo.opensource-socialnetwork.org/u/wVandervort
 *            https://demo.opensource-socialnetwork.org/u/Makenna51
 *            https://demo.opensource-socialnetwork.org/u/Anika25
 *            https://demo.opensource-socialnetwork.org/u/wMoen
 *        - Proverava da li na stranici postoji Add Friend dugme
 *        - Salje zahtev za prijateljstvo
 *        - Proverava da li je prikazana poruka koja sadrzi tekst "Friend Request Sent"
 *        - Proverava da li na stranici postoji dugme Cancel Request
 *        - Zatim osvezava stranicu i
 *        - Opet proverava da li na stranici postoji dugme Cancel Request
 *        - Ponistava zahtev za prijateljstvo
 *        - Proverava da li je prikazana poruka koja sadrzi tekst "Friend request deleted!"
 *        - I na kraju proverava da li je na stranici prikazano "Add Friend" dugme
 *        - U AfterClass metodi zatvara stranicu
 */

package POM.Zadatak01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RequestTest {

  private WebDriver driver;
  private WebDriverWait driverWait;
  private LoginPage loginPage;
  private FriendPage friendPage;

  @BeforeClass
  public void beforeClass() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    loginPage = new LoginPage(driver, driverWait);
    friendPage = new FriendPage(driver, driverWait);

    driver.navigate().to("https://demo.opensource-socialnetwork.org/login");
  }

  @AfterClass
  public void afterClass() {
//    driver.close();
  }

  @Test (priority = 1)
  public void loginTest() {

    loginPage.login("administrator", "administrator");
    Assert.assertTrue(loginPage.isLoginButtonEnabled());
    loginPage.clickLoginButton();
    Assert.assertEquals(driver.getTitle(), "News Feed : Open Source Social Network");
  }

  @Test (priority = 2)
  public void addFriendTest() {

    driver.navigate().to("https://demo.opensource-socialnetwork.org/u/Keyshawn89");
    Assert.assertTrue(friendPage.isDisplayedAddFriend());
    friendPage.addFriendClick();
    Assert.assertEquals(friendPage.getMessage(), "Friend Request Sent");
  }

  @Test (priority = 3)
  public void cancelRequestTest() {

    Assert.assertTrue(friendPage.isDisplayedCancelRequest());
    driver.navigate().refresh();
    Assert.assertTrue(friendPage.isDisplayedCancelRequest());
    friendPage.cancelRequestClick();
    Assert.assertEquals(friendPage.getMessage(), "Friend request deleted!");
    Assert.assertTrue(friendPage.isDisplayedAddFriend());
  }
}