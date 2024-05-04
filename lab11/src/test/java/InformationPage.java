import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;

public class InformationPage {

    private WebDriver driver;
    private By InfButtonSearch = By.xpath("/html/body/header/div[3]/div/div/ul/li[3]/a");
    private By InfButtonClickTwo = By.xpath("/html/body/main/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]");


    public InformationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void InfButtonClick(){

        WebElement InfButton = driver.findElement(InfButtonSearch);

        InfButton.click();


    }
    public void InfButtonSecondClick(){

        WebElement InfButtonSec = driver.findElement(InfButtonClickTwo);

        InfButtonSec.click();


    }

    public void goToHomePage() {
        driver.get("https://tabletka.by/");
    }

}
