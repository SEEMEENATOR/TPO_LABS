import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePageNew {

    private WebDriver driver;
    private By linkToProductPageSelector = By.xpath("//*[@id=\"base-select\"]/tbody/tr[1]/td[2]/div/div[1]/div/a");

    public HomePageNew(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://tabletka.by/");
    }

    public void searchForProduct(String productName) {
        By searchInputSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/div[1]/input");
        By searchButtonSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/button");

        WebElement searchInput = driver.findElement(searchInputSelector);
        WebElement searchButton = driver.findElement(searchButtonSelector);

        searchInput.sendKeys(productName);
        searchButton.click();
    }

    public WebElement getLinkToProductPage() {
        return driver.findElement(linkToProductPageSelector);
    }
}
