/* RAD NA CASU, 31. 05. 2022. ZADATAK 2.
 *
 * Napisati program koji učitava stranicu
 * https://crop-circle.imageonline.co/#circlecropresult
 * i upload-ujte sliku na sajt.
 *
 * Kliknite na dugme Crop Circle i preuzeti korigovanu sliku
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak02 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.navigate().to("https://crop-circle.imageonline.co/#circlecropresult");

    File image = new File("img/profile-image.png");

    WebElement uploadBtn = driver.findElement(By.id("inputImage"));
    uploadBtn.sendKeys(image.getAbsolutePath());

    WebDriverWait cropWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    cropWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("photobutton")));

    WebElement cropButton = driver.findElement(By.id("photobutton"));
    cropButton.click();

    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("download")));

    WebElement downloadButton = driver.findElement(By.id("download"));
    downloadButton.click();
  }
}