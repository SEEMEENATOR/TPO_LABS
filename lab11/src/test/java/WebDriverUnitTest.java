import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertNotNull;

public class WebDriverUnitTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private PharamacyPage pharamacyPage;
    private FavoritePage favoritePage;
    private FavPhar favPhar;
    private Phar24 phar24;
    private ReservePage reservePage;
    private HomePageNew homePageNew;
    private ProductPage productPage;
    private PharmacyPageNew pharmacyPageNew;
    private InformationPage informationPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\maksi\\OneDrive\\Рабочий стол\\Новая папка\\Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        pharamacyPage = new PharamacyPage(driver);
        favoritePage = new FavoritePage(driver);
        favPhar = new FavPhar(driver);
        phar24 = new Phar24(driver);
        reservePage = new ReservePage(driver);
        homePageNew = new HomePageNew(driver);
        productPage = new ProductPage(driver);
        pharmacyPageNew = new PharmacyPageNew(driver);
        informationPage = new InformationPage(driver);

    }

    @Test
    public void SortProduct() throws InterruptedException {
        homePage.goToHomePage();
        homePage.goToSearchPage();
        Thread.sleep(3000);
    }
    @Test
    public void LoginTest() throws InterruptedException{
   loginPage.goToHomePage();
   Thread.sleep(3000);
        loginPage.LoginForm();
        Thread.sleep(3000);
        loginPage.LoginConfirm("dsad","dsadsadasda");
        Thread.sleep(2000);

    }
    @Test
    public void SearhDrugIntoPhar() throws InterruptedException {
        pharamacyPage.goToHomePage();
        Thread.sleep(2000);
        pharamacyPage.SearchDrugs();
        Thread.sleep(3000);
    }
    @Test
    public void FavorTest() throws InterruptedException {
        favoritePage.goToHomePage();
        favoritePage.FavorElem();
        Thread.sleep(3000);
        favoritePage.FavElemClick();
        Thread.sleep(3000);
    }
    @Test
    public void FavorTestPhar() throws InterruptedException {
        favPhar.goToHomePage();
        favPhar.FavorElem();
        Thread.sleep(3000);
        favPhar.FavElemClick();
        Thread.sleep(5000);
    }
    @Test
    public void FindPharTest() throws InterruptedException {
        phar24.goToHomePage();
        phar24.ClickPhar();
        Thread.sleep(3000);
        phar24.FindPhar();
        Thread.sleep(5000);
    }
    @Test
    public void ReserveDrug() throws InterruptedException {
        reservePage.goToHomePage();
       reservePage.DrugClick();
        Thread.sleep(5000);
        driver.get("https://tabletka.by/reserved?apt=7950&ls=110084");
        Thread.sleep(3000);
    }
    @Test
    public void testSearchAndNavigateToProductPage() throws InterruptedException {
        homePageNew.goToHomePage();
        homePageNew.searchForProduct("гриппомикс");

        Thread.sleep(5000);

        assertNotNull(homePageNew.getLinkToProductPage());

        String href = homePageNew.getLinkToProductPage().getAttribute("href");
        productPage.goToProductPage(href);

        Thread.sleep(2000);
    }
    @Test
    public void testSearcheToProductPageWithPhar() throws InterruptedException {
        homePageNew.goToHomePage();
        homePageNew.searchForProduct("нозакар");

        Thread.sleep(5000);

        assertNotNull(pharmacyPageNew.getLinkToProductPage());

        pharmacyPageNew.clickOnFirstProduct();
        Thread.sleep(2000);

        pharmacyPageNew.clickOnSecondProduct();
        Thread.sleep(2000);


    }
    @Test
    public void InfPageTest() throws InterruptedException {
       informationPage.goToHomePage();
       Thread.sleep(2000);
       informationPage.InfButtonClick();
        Thread.sleep(5000);
        informationPage.InfButtonSecondClick();
        Thread.sleep(3000);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
