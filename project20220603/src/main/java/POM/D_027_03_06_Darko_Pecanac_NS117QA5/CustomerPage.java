package POM.D_027_03_06_Darko_Pecanac_NS117QA5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage extends BasePage {

  public CustomerPage(WebDriver driver, WebDriverWait driverWait) {

    super(driver, driverWait);
  }

  public void clickCustomerHomeBtn() {

    getDriver().findElement(By.className("home")).click();
  }
}
