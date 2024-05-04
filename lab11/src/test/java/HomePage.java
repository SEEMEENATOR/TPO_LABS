import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage {

    private WebDriver driver;
    private By linkToProductPageSelector = By.xpath("//*[@id=\"base-select\"]/tbody/tr[1]/td[2]/div/div[1]/div/a");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://tabletka.by/");
    }
    public void goToSearchPage(){

        driver.get("https://tabletka.by/drugs");
    }


    public WebElement getLinkToProductPage() {
        return driver.findElement(linkToProductPageSelector);
    }
}
