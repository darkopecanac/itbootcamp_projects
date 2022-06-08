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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class Zadatak03 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//    /****************   KOREKCIJA ZA DOWNLOAD DA NE OTVARA SAVE AS DIALOG **************************/
//    ChromeOptions options = new ChromeOptions();
//    HashMap<String, Object> prefs = new HashMap<>();
//    prefs.put("download.prompt_for_download", false);
//    options.setExperimentalOption("prefs", prefs);
//    WebDriver driver = new ChromeDriver(options); // prosledjujemo dodatne opcije da bismo zabranili otvarenje saveAs dijaloga
//    /***********************************************************************************************/
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.navigate().to("https://www.file.io/");

    File uploadVideo = new File("uploads/Ovca.mp4");
    WebElement uploadBtn = driver.findElement(By.id("upload-button"));
    uploadBtn.sendKeys(uploadVideo.getAbsolutePath());

    WebDriverWait waitingDownload = new WebDriverWait(driver, Duration.ofSeconds(50));
    waitingDownload.until(ExpectedConditions.presenceOfElementLocated(By.id("download-url")));

    WebElement downloadReady = driver.findElement(By.id("download-url"));
    String url = downloadReady.getAttribute("value");
    System.out.println(url);

    // Otvaramo stranu i download-ujemo fajl
    driver.navigate().to(url);
    waitingDownload.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
            "//*[@id=\"gatsby-focus-wrapper\"]/div/div[3]/div/div/div/div[3]/a")));
    WebElement downloadButton = driver.findElement(By.xpath(
            "//*[@id=\"gatsby-focus-wrapper\"]/div/div[3]/div/div/div/div[3]/a"));
    downloadButton.click();

    //driver.close();
  }
}