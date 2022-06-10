package POM.D_027_03_06_Darko_Pecanac_NS117QA5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerPage extends BasePage {

  private By addCustomerTab = By.xpath("//*[contains(text(), 'Add Customer')]");
  private By firstName = By.xpath("//input[@ng-model='fName']");
  private By lastName = By.xpath("//input[@ng-model='lName']");;
  private By postCode = By.xpath("//input[@ng-model='postCd']");;
  private By addCustomerSubmit = By.xpath("//button[@type='submit']");

  private By openAccountTab = By.xpath("//button[@ng-class='btnClass2']");
  private By customersTab = By.xpath("//button[@ng-class='btnClass3']");

  public ManagerPage(WebDriver driver, WebDriverWait driverWait) {

    super(driver, driverWait);
  }

  public void addCustomer(String firstName, String lastName, String postCode) throws InterruptedException {
    getDriver().findElement(this.addCustomerTab).click();
    Thread.sleep(1000);
    getDriver().findElement(this.firstName).sendKeys(firstName);
    getDriver().findElement(this.lastName).sendKeys(lastName);
    getDriver().findElement(this.postCode).sendKeys(postCode);
    getDriver().findElement(addCustomerSubmit).click();
    getDriver().switchTo().alert().accept();
  }

  public boolean isCustomerCreated(String firstName) throws InterruptedException {

    getDriver().findElement(this.customersTab).click();
    Thread.sleep(1000);

    String actualCustomerName = getDriver().findElement(By.xpath(
            "//td[contains(text(), '" + firstName + "')]")).getText();

    if ( actualCustomerName.equals(firstName) )
      return true;
    return false;
  }

  public void addAccount(String firstName, String lastName) throws InterruptedException {
    getDriver().findElement(this.openAccountTab).click();
    Thread.sleep(1000);

    getDriver().findElement(By.id("userSelect")).click();
    getDriver().findElement(By.xpath(
            "//option[contains(text(), '" + firstName + " " + lastName + "')]")).click();

    getDriver().findElement(By.id("currency")).click();
    getDriver().findElement(By.xpath("//option[@value='Rupee']")).click();

    getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    getDriver().switchTo().alert().accept();
  }

  public boolean isAccountCreated() throws InterruptedException {

    getDriver().findElement(this.customersTab).click();
    Thread.sleep(1000);

    String accountNumber = getDriver().findElement(By.xpath(
            "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[4]")).getText();

    return accountNumber.length() > 0;
  }

  public void clickManagerLogoutBtn() {

    getDriver().findElement(By.className("home")).click();
  }
}