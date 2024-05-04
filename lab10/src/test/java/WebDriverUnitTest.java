import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertNotNull;

public class WebDriverUnitTest {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\maksi\\OneDrive\\Рабочий стол\\Новая папка\\Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testSearchAndNavigateToProductPage() throws InterruptedException {
        homePage.goToHomePage();
        homePage.searchForProduct("гриппомикс");

        Thread.sleep(5000);

        assertNotNull(homePage.getLinkToProductPage());

        String href = homePage.getLinkToProductPage().getAttribute("href");
        productPage.goToProductPage(href);

        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
