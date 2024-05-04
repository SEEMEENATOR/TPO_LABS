import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;

public class PharamacyPage {

    private WebDriver driver;
    private By DrugButtonSearch = By.xpath("/html/body/main/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/div/div[1]/div/a");
    public PharamacyPage(WebDriver driver) {
        this.driver = driver;
    }
    public void SearchDrugs(){

        WebElement DrugButton = driver.findElement(DrugButtonSearch);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); // Прокрутка на 1000 пикселей вниз (можете изменить значение по своему усмотрению)
        DrugButton.click();


    }
    public void goToHomePage() {
        driver.get("https://tabletka.by/pharmacies/8373");
    }

}
