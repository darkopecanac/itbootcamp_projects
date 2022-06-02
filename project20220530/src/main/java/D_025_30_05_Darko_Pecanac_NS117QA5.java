/* DOMAĆI 30. 05. 2022, 1. ZADATAK:
 *
 * Otići na http://www.strela.co.rs/,
 * kliknuti na dugme Prodavnica u headeru,
 * izabrati opciju Lukovi - Bows iz leve navigacije,
 * potom kliknuti na luk koji se zove Samick Sage,
 * i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class D_025_30_05_Darko_Pecanac_NS117QA5 {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.navigate().to("http://www.strela.co.rs/");

    WebElement webElementProdavnica = driver.findElement(By.xpath(
            "//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]"));
    webElementProdavnica.click();

    WebElement webElementBows = driver.findElement(By.xpath(
            "//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
    webElementBows.click();

    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
            "//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));

    WebElement webElementBow = driver.findElement(By.xpath(
            "//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
    webElementBow.click();

    WebElement webElementSamic = driver.findElement(By.id(
            "ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));

    String expected = "Samic";
    String actual = webElementSamic.getText();

    if ( actual.contains(expected) )
      System.out.println("Ime luka sadrzi rec \"" + expected + "\".");
    else
      System.out.println("Ime luka ne sadrzi rec \"" + expected + "\".");
  }
}