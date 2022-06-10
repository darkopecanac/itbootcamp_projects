package POM.Zadatak01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

  private By username = By.name("username");
  private By password = By.name("password");
  private By loginButton = By.xpath("//*[@id=\"ossn-login\"]/fieldset/div[4]/input");

  public LoginPage(WebDriver driver, WebDriverWait driverWait) {
    super(driver, driverWait);
  }

  public void enterUsername(String username) {
    getDriver().findElement(this.username).sendKeys(username);
  }

  public void enterPassword(String password) {
    getDriver().findElement(this.password).sendKeys(password);
  }

  public void login(String username, String password) {
    clearField(this.username);
    enterUsername(username);
    clearField(this.password);
    enterPassword(password);
  }

  public boolean isLoginButtonEnabled() {
      return getDriver().findElement(loginButton).isEnabled();
  }

  public void clickLoginButton() {
      getDriver().findElement(loginButton).click();
  }
}