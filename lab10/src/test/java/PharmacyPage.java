import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PharmacyPage {

    private WebDriver driver;
    private By linkToProductPageSelector = By.xpath("//*[@id=\"base-select\"]/tbody/tr[1]/td[2]/div/div[1]/div/a");
    private By firstProductSelector = By.xpath("//*[@id=\"base-select\"]/tbody/tr[1]/td[2]/div/div[1]/div/a");
    private By secondProductSelector = By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/div/div[1]/div/a");

    public PharmacyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFirstProduct() {
        driver.findElement(firstProductSelector).click();
    }

    public void clickOnSecondProduct() {
        driver.findElement(secondProductSelector).click();
    }

    public boolean isLinkToProductPageDisplayed() {
        return driver.findElement(linkToProductPageSelector).isDisplayed();
    }

    public WebElement getLinkToProductPage() {
        return driver.findElement(linkToProductPageSelector);
    }
}
