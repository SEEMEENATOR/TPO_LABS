import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;

public class FavoritePage {

    private WebDriver driver;
    private By DrugButtonSearch = By.xpath("//*[@id=\"base-select\"]/tbody/tr[1]/td[1]/div");
    private By FavPageButton = By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div");
    public FavoritePage(WebDriver driver) {
        this.driver = driver;
    }
    public void FavorElem(){

        WebElement DrugButton = driver.findElement(DrugButtonSearch);

        DrugButton.click();

    }
    public void FavElemClick(){
        WebElement DrugButtonCl = driver.findElement(FavPageButton);
        DrugButtonCl.click();
    }
    public void goToHomePage() {
        driver.get("https://tabletka.by/search?request=%D0%9D%D0%BE%D0%B7%D0%B0%D0%BA%D0%B0%D1%80");
    }

}
