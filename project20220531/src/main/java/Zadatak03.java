/* RAD NA CASU, 31. 05. 2022. ZADATAK 3. (za vežbanje)
 *
 * Napisati program koji učitava stranicu
 * https://www.file.io/
 * upload-uje fajl (proizvoljan, ali neka bude nekih 20tak MB)
 * i čekamo da se prikaze link za download.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak03 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.navigate().to("https://www.file.io/");

    File uploadVideo = new File("uploads/Ovca.mp4");

    WebElement uploadBtn = driver.findElement(By.id("upload-button"));
    uploadBtn.sendKeys(uploadVideo.getAbsolutePath());

    WebDriverWait waitingDownload = new WebDriverWait(driver, Duration.ofSeconds(10));
    waitingDownload.until(ExpectedConditions.visibilityOfElementLocated(By.id("download-url")));

    WebElement downloadReady = driver.findElement(By.id("download-url"));
    downloadReady.click();

  /*
    WebElement cropButton = driver.findElement(By.id("photobutton"));
    cropButton.click();

    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("download")));

    WebElement downloadButton = driver.findElement(By.id("download"));
    downloadButton.click();
  */
  }
}