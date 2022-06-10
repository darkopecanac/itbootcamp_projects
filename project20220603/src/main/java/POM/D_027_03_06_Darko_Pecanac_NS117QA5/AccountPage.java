package POM.D_027_03_06_Darko_Pecanac_NS117QA5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

  private By depositBtn = By.xpath("//button[@ng-class='btnClass2']");
  private By withdrawlBtn = By.xpath("//button[@ng-class='btnClass3']");
  private By amount = By.xpath("//input[@ng-model='amount']");
  private By submitBtn = By.xpath("//button[@type='submit']");

  public AccountPage(WebDriver driver, WebDriverWait driverWait) {

    super(driver, driverWait);
  }

  public boolean accountDeposit(String depositAmount) throws InterruptedException {

    getDriver().findElement(depositBtn).click();
    Thread.sleep(1000);
    getDriver().findElement(amount).sendKeys(depositAmount);
    getDriver().findElement(submitBtn).click();
    String actualMessage = getDriver().findElement(By.xpath("//span[@ng-show='message']")).getText();
    return actualMessage.equals("Deposit Successful");
  }

  public boolean accountWithdrawl(String withdrawlAomunt) throws InterruptedException {
    getDriver().findElement(withdrawlBtn).click();
    Thread.sleep(1000);
    getDriver().findElement(amount).sendKeys(withdrawlAomunt);
    getDriver().findElement(submitBtn).click();
    String actualMessage = getDriver().findElement(By.xpath("//span[@ng-show='message']")).getText();
    return actualMessage.equals("Transaction successful");
  }

  public void clickCustomerLogoutBtn() throws InterruptedException {

    getDriver().findElement(By.className("logout")).click();
    Thread.sleep(1000);
  }
}
