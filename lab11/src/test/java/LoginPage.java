import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {

    private WebDriver driver;
    private By loginButtonClick = By.xpath("/html/body/header/div[1]/div/div/div/div[3]/a");
    private By searchInputField = By.xpath("//*[@id=\"login-name\"]");
    private By searchInputField1 = By.xpath("//*[@id=\"login-pass\"]");
    private By buttonConfirmField = By.xpath("//*[@id=\"bttn-login\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginForm(){

        WebElement loginButton = driver.findElement(loginButtonClick);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(1000, 0)"); // Прокрутка на 1000 пикселей вправо (можете изменить значение по своему усмотрению)
        loginButton.click();


    }
    public void LoginConfirm(String login, String password){
        WebElement searchLogin = driver.findElement(searchInputField);
        WebElement searchPass = driver.findElement(searchInputField1);
        searchLogin.sendKeys(login);
        searchPass.sendKeys(password);
        WebElement buttonLogin = driver.findElement(buttonConfirmField);
        buttonLogin.click();
    }

    public void goToHomePage() {
        driver.get("https://tabletka.by/");
    }

}
