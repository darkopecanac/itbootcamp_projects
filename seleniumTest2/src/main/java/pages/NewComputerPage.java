package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewComputerPage extends BasePage {

  By computerName = By.id("name");
  By createButton = By.xpath("//*[@id='main']/form/div/input");

  By creationMessageField = By.xpath("//*[@id='main']/div[1]");

  public NewComputerPage(WebDriver webDriver, WebDriverWait webDriverWait) {
    super(webDriver, webDriverWait);
  }

  public void addNewComputer(String name) {
    getWebDriver().findElement(computerName).sendKeys(name);
    getWebDriver().findElement(createButton).click();
  }

  public boolean validateCreationMessage(String name) {
    return getWebDriver().findElement(creationMessageField).isDisplayed() &&
            getWebDriver().findElement(creationMessageField).getText().contains(name);
  }
}
