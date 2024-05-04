import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageNew {

    private WebDriver driver;
    private By searchInputSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/div[1]/input");

    private By searchButtonSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/button");

    public ProductPageNew(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://tabletka.by/");
    }

    public void searchForProduct(String productName) {
        WebElement searchInput = driver.findElement(searchInputSelector);
        WebElement searchButton = driver.findElement(searchButtonSelector);


        searchInput.sendKeys(productName);
        searchButton.click();
    }
}
