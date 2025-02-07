package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import java.time.Duration;

import static utils.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    YourCartPage yourCartPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            EdgeOptions optionsE =new EdgeOptions();
            optionsE.addArguments("--headless");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void dropdown(ITestResult result ) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(driver);
        }
        driver.quit();
    }
}
