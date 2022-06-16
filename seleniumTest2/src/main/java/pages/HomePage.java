package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

  By searchField = By.id("searchbox");
  By searchButton = By.id("searchsubmit");
  By searchResultMessage = By.xpath("//*[@id='main']/h1");

  By addANewComputerButton = By.id("add");

  public HomePage(WebDriver webDriver, WebDriverWait webDriverWait) {
    super(webDriver, webDriverWait);
  }

  public void searchByString(String searchString) {
    getWebDriver().findElement(searchField).sendKeys(searchString);
    getWebDriver().findElement(searchButton).click();
  }

  public boolean searchResult() {
    return getWebDriver().findElement(searchResultMessage).getText().equals("6 computers found");
  }

  public boolean sixRowsPresent() {
    List<WebElement> rowsInTable = getWebDriver().findElements(By.xpath("//*[@id='main']/table/tbody/tr"));
    return rowsInTable.size() == 6;
  }

  public void addNewComputer() {
    getWebDriver().findElement(addANewComputerButton).click();
  }
}
