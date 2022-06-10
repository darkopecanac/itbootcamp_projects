package POM.Zadatak01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FriendPage extends BasePage {

  private By addFriend = By.xpath("//*[contains(text(), 'Add Friend')]");
  private By cancelRequest = By.xpath("//*[contains(text(), 'Cancel Request')]");
  private By infoMessage = By.xpath("/html/body/div[5]/div[2]/div[2]/div/div/div[1]/div/div/div/div");

  public FriendPage(WebDriver driver, WebDriverWait driverWait) {
    super(driver, driverWait);
  }

  public boolean isDisplayedAddFriend() {
    return getDriver().findElement(addFriend).isDisplayed();
  }

  public void addFriendClick() {
    getDriver().findElement(addFriend).click();
  }

  // Friend request sent
  public String getMessage() {
    return getDriver().findElement(infoMessage).getText();
  }

  public boolean isDisplayedCancelRequest() {
    return getDriver().findElement(cancelRequest).isDisplayed();
  }

  public void cancelRequestClick() {
    getDriver().findElement(cancelRequest).click();
  }
}