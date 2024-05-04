import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertNotNull;

public class WebDriverUnitTest2 {

    private WebDriver driver;
    private ProductPageNew homePage;
    private PharmacyPage pharmacyPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\maksi\\OneDrive\\Рабочий стол\\Новая папка\\Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        homePage = new ProductPageNew(driver);
        pharmacyPage = new PharmacyPage(driver);
    }

    @Test
    public void testSearchAndNavigateToProductPage() throws InterruptedException {
        homePage.goToHomePage();
        homePage.searchForProduct("нозакар");

        Thread.sleep(5000);

        assertNotNull(pharmacyPage.getLinkToProductPage());

        pharmacyPage.clickOnFirstProduct();
        Thread.sleep(2000);

        pharmacyPage.clickOnSecondProduct();
        Thread.sleep(2000);


    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
