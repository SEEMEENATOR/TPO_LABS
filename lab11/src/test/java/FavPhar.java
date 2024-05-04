import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;

public class FavPhar {

    private WebDriver driver;
    private By DrugButtonSearch = By.xpath("/html/body/main/div[2]/div[1]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[1]/div");
    private By FavPageButton = By.xpath("/html/body/header/div[1]/div/div/div/div[3]/div");
    private By FavPageButton1 = By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]");

    public FavPhar(WebDriver driver) {
        this.driver = driver;
    }
    public void FavorElem(){

        WebElement DrugButton = driver.findElement(DrugButtonSearch);

        DrugButton.click();

    }
    public void FavElemClick(){
        WebElement DrugButtonCl = driver.findElement(FavPageButton);
        DrugButtonCl.click();
        WebElement DrugButtonCl1 = driver.findElement(FavPageButton1);
        DrugButtonCl1.click();
    }
    public void goToHomePage() {
        driver.get("https://tabletka.by/pharmacies?region=1001");
    }

}
