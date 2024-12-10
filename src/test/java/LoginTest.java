import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkPositiveLogin() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String loginText = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText();
        Assert.assertEquals(loginText, "Products");
    }

    @Test
    public void checkNegativeLoginWrongPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("abcdefghijk");
        driver.findElement(By.id("login-button")).click();
        String errorText = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
        Assert.assertEquals(errorText,"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void checkNegativeLoginWrongUser() {
        driver.findElement(By.name("user-name")).sendKeys("wrong_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean errorMassage = driver.findElement(By.xpath("/html/body")).isDisplayed();
        Assert.assertTrue(errorMassage);
    }

    @Test
    public void checkNegativeLoginWithoutText() {
        driver.findElement(By.name("user-name")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String errorTextSecond = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
        Assert.assertEquals(errorTextSecond, "Epic sadface: Username is required");
    }

    @AfterMethod (alwaysRun = true)
    public void dropdown() {
        driver.quit();
    }
}
