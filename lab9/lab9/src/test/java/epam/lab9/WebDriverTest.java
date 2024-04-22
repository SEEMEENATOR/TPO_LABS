package epam.lab9;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverTest {
  public static void main(String[] args) throws InterruptedException {


    System.setProperty("webdriver.edge.driver", "C:\\Users\\maksi\\OneDrive\\Рабочий стол\\Новая папка\\Drivers\\msedgedriver.exe");


    WebDriver driver  = new EdgeDriver();
    driver.get("https://tabletka.by/");

    By searchInputSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/div[1]/input");
    By searchButtonSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/button");

    WebElement searchInput = driver.findElement(searchInputSelector);
    WebElement searchButton = driver.findElement(searchButtonSelector);

    searchInput.sendKeys("гриппомикс");
    searchButton.click();

    Thread.sleep(5000);
    By linkToProductPageSelector = By.xpath("//*[@id=\"base-select\"]/tbody/tr[1]/td[2]/div/div[1]/div/a");
    WebElement linkToProductPage = driver.findElement(linkToProductPageSelector);
    Thread.sleep(5000);

    String href = linkToProductPage.getAttribute("href");
    driver.get(href);
    Thread.sleep(2000);

    driver.quit();
  }
}
