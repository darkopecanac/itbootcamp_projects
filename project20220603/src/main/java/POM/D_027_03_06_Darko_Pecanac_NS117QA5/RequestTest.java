/* DOMAĆI 03. 06. 2022, 1. ZADATAK:
 *
 * Otići na https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
 *
 * Test 1: Logovanje kao Bank Manager
 * Test 2: Kreiranje Customera
 * Test 3: Kreiranje Accounta za tog Customera
 * Test 4: Logovanje kao Customer
 * Test 5: Uspešan Deposit za nekog Customera
 * Test 6: Uspešan Withdrawal za nekog Customera
 * Test 7: Logout za Bank Managera
 * Test 8: Logout za Customera
 *
 * Prolaz (ocena 3) - Testovi 1, 2, 4, 5.
 * Obavezno koristiti POM.
 *
 * May the odds be ever in your favor.
 */

package POM.D_027_03_06_Darko_Pecanac_NS117QA5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RequestTest {

  private String customerFirstName = "Marko";
  private String customerLastName = "Markovic";
  private String customerPostCode = "21000";

  private String loginUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
  private String managerUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
  private String customerUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
  private String accountUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account";

  private WebDriver driver;
  private WebDriverWait driverWait;
  private LoginPage loginPage;
  private ManagerPage managerPage;
  private CustomerPage customerPage;
  private AccountPage accountPage;

  @BeforeClass
  public void beforeClass() {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    driverWait = new WebDriverWait(driver, Duration.ofSeconds(8));

    loginPage = new LoginPage(driver, driverWait);
    managerPage = new ManagerPage(driver, driverWait);
    customerPage = new CustomerPage(driver, driverWait);
    accountPage = new AccountPage(driver, driverWait);
    driver.navigate().to(loginUrl);
  }

  @AfterClass
  public void afterClass() {

    driver.close();
  }

  @Test (priority = 1)
  public void managerLoginTest() throws InterruptedException {

//    driver.navigate().to(loginUrl);
    loginPage.clickManagerLoginBtn();
    Assert.assertEquals(driver.getCurrentUrl(), managerUrl);
  }

  @Test (priority = 2)
  public void createCustomerTest() throws InterruptedException {

    managerPage.addCustomer(customerFirstName, customerLastName, customerPostCode);
    Assert.assertTrue(managerPage.isCustomerCreated(customerFirstName));
  }

  @Test (priority = 3)
  public void createCustomerAccountTest () throws InterruptedException {
    managerPage.addAccount(customerFirstName, customerLastName);
    managerPage.addAccount(customerFirstName, customerLastName);
    Assert.assertTrue(managerPage.isAccountCreated());
  }

  @Test (priority = 4)
  public void managerLogoutTest() {
    managerPage.clickManagerLogoutBtn();
    Assert.assertEquals(driver.getCurrentUrl(), loginUrl);
  }

  @Test (priority = 5)
  public void customerLoginTest() throws InterruptedException {

    loginPage.clickCustomerLoginBtn();
    Assert.assertEquals(driver.getCurrentUrl(), customerUrl);
    Assert.assertTrue(loginPage.loginCustomer(customerFirstName, customerLastName));
    Assert.assertEquals(driver.getCurrentUrl(), accountUrl);
  }

  @Test (priority = 6)
  public void customerDepositTest() throws InterruptedException {
    Assert.assertTrue(accountPage.accountDeposit("10000"));
  }

  @Test (priority = 7)
  public void customerWithdrawlTest() throws InterruptedException {
    Assert.assertTrue(accountPage.accountWithdrawl("5000"));
  }

  @Test (priority = 8)
  public void customerLogoutButtonTest() throws InterruptedException {

    accountPage.clickCustomerLogoutBtn();
    Assert.assertEquals(driver.getCurrentUrl(), customerUrl);
  }

//  @Test (priority = 9)
//  public void customerHomeButtonTest() {
//
//    customerPage.clickCustomerHomeBtn();
//    Assert.assertEquals(driver.getCurrentUrl(), loginUrl);
//  }
}