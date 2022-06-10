package POM.D_027_03_06_Darko_Pecanac_NS117QA5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

  private By manager = By.xpath("//*[contains(text(), 'Bank Manager Login')]");
  private By customer = By.xpath("//*[contains(text(), 'Customer Login')]");
  public LoginPage(WebDriver driver, WebDriverWait driverWait) {
    super(driver, driverWait);
  }

  public void clickManagerLoginBtn() throws InterruptedException {

    Thread.sleep(1000);
    getDriver().findElement(manager).click();
    Thread.sleep(1000);
  }

  public void clickCustomerLoginBtn() throws InterruptedException {

    Thread.sleep(1000);
    getDriver().findElement(customer).click();
    Thread.sleep(1000);
  }

  public boolean loginCustomer(String firstName, String lastName) throws InterruptedException {
    String customer = firstName + " " + lastName;

    getDriver().findElement(By.id("userSelect")).click();
    getDriver().findElement(By.xpath(
            "//option[contains(text(), '" + firstName + " " + lastName + "')]")).click();

    getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000);

    String actualCustomer = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/strong/span")).getText();

    if ( actualCustomer.equals(customer))
      return true;
    return false;
  }
}