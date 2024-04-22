package epam.lab9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WebDriverUnitTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\maksi\\OneDrive\\Рабочий стол\\Новая папка\\Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void testSearchAndNavigateToProductPage() throws InterruptedException {
        driver.get("https://tabletka.by/");

        By searchInputSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/div[1]/input");
        By searchButtonSelector = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/form/div[2]/div/button");

        WebElement searchInput = driver.findElement(searchInputSelector);
        WebElement searchButton = driver.findElement(searchButtonSelector);

        searchInput.sendKeys("гриппомикс");
        searchButton.click();

        Thread.sleep(5000);
        By linkToProductPageSelector = By.xpath("//*[@id=\"base-select\"]/tbody/tr[1]/td[2]/div/div[1]/div/a");
        WebElement linkToProductPage = driver.findElement(linkToProductPageSelector);
        assertNotNull(linkToProductPage);

        String href = linkToProductPage.getAttribute("href");
        driver.get(href);
        Thread.sleep(2000);

        // Example assertion, you may need to adjust it according to your requirements

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
