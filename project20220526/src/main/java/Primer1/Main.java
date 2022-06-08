package Primer1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                       "e:\\_BOOT CAMP\\_QA KURS\\_WORK\\JAVA_PROJECTS\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.get("http://www.google.rs");

    String title = driver.getTitle();
    String expected = "Google";

    if ( title.equals(expected) )
      System.out.println("Validno!");

//    WebElement el = driver.findElement(By.xpath(
//            "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
    WebElement el = driver.findElement(By.name("q"));
    el.sendKeys("Selenium Java");
    el.submit();

    driver.close();
  }
}