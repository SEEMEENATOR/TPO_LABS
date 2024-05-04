import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;

public class Phar24 {

    private WebDriver driver;
    private By PharButtonSearch = By.xpath("/html/body/main/div[2]/div[1]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/div[1]/a");
    private By FindPharButton = By.xpath("/html/body/main/div[2]/div/div[1]/div[1]/a");
    private By FavPageButton1 = By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]");

    public Phar24(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickPhar(){

        WebElement PharClick = driver.findElement(PharButtonSearch);

        PharClick.click();

    }
    public void FindPhar(){
        WebElement PharFind = driver.findElement(FindPharButton);
        PharFind.click();

    }
    public void goToHomePage() {
        driver.get("https://tabletka.by/pharmacies?region=1001");
    }

}
