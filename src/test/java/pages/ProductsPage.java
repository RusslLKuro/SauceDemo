package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    By shoppingCart = By.cssSelector("[data-test=shopping-cart-link]");
    By sauceLabsBackpack = By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]");
    By sauceLabsBikeLight = By.cssSelector("[data-test=add-to-cart-sauce-labs-bike-light]");
    By sauceLabsBoltTShirt = By.cssSelector("[data-test=add-to-cart-sauce-labs-bolt-t-shirt]");
    By sauceLabsFleeceJacket = By.cssSelector("[data-test=add-to-cart-sauce-labs-fleece-jacket]");
    By sauceLabsOnesie = By.cssSelector("[data-test=add-to-cart-sauce-labs-onesie]");
    By sauceLabsTShitRed = By.name("add-to-cart-test.allthethings()-t-shirt-(red)");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void openShoppingCart() {
        driver.findElement(shoppingCart).click();
    }

    public void clickSauceLabsBackpack() {
        driver.findElement(sauceLabsBackpack).click();
    }

    public void clickSauceLabsBikeLight() {
        driver.findElement(sauceLabsBikeLight).click();
    }

    public void clickSauceLabsBoltTShirt() {
        driver.findElement(sauceLabsBoltTShirt).click();
    }

    public void clickSauceLabsFleeceJacket() {
        driver.findElement(sauceLabsFleeceJacket).click();
    }

    public void clickSauceLabsOnesie() {
        driver.findElement(sauceLabsOnesie).click();
    }

    public void clickSauceLabsTShitRed() {
        driver.findElement(sauceLabsTShitRed).click();
    }

    public void buyAllProducts() {
        driver.findElement(sauceLabsBackpack).click();
        driver.findElement(sauceLabsBikeLight).click();
        driver.findElement(sauceLabsBoltTShirt).click();
        driver.findElement(sauceLabsFleeceJacket).click();
        driver.findElement(sauceLabsOnesie).click();
        driver.findElement(sauceLabsTShitRed).click();
    }
}
