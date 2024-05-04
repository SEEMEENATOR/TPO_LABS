import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;

public class ReservePage {

    private WebDriver driver;
    private By DrugsButtonSearch = By.xpath("/html/body/main/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/div/div[1]/div/a");
    private By ReserveButtonSearch = By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div/table/tbody/tr[1]/td[5]/div/div[2]");
    private By FavPageButton1 = By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]");

    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }
    public void DrugClick(){

        WebElement drugSearch = driver.findElement(DrugsButtonSearch);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); // Прокрутка на 1000 пикселей вниз (можете изменить значение по своему усмотрению)
        drugSearch.click();

    }
    public void ReserveClick(){
        WebElement ReservSearch = driver.findElement(ReserveButtonSearch);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(1000, 0)");
        ReservSearch.click();

    }
    public void goToHomePage() {
        driver.get("https://tabletka.by/pharmacies/7950");
    }

}
