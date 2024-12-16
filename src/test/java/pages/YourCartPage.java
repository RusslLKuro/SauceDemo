package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {

    WebDriver driver;

    By removeSauceLabsBackpack = By.cssSelector("[data-test=remove-sauce-labs-backpack]");
    By removeSauceLabsBikeLight = By.cssSelector("[data-test=remove-sauce-labs-bike-light]");
    By removeLabsBoltTShirt = By.cssSelector("[data-test=remove-sauce-labs-bolt-t-shirt]");
    By removeLabsFleeceJacket = By.cssSelector("[data-test=remove-sauce-labs-fleece-jacket]");
    By removeLabsOnesie = By.cssSelector("[data-test=remove-sauce-labs-onesie]");
    By removeLabsTShitRed = By.cssSelector("[data-test=remove-test.allthethings()-t-shirt-(red)]");
    By fleeceJacket = By.cssSelector("[data-test=item-5-title-link]");
    By onesie = By.cssSelector("[data-test=item-2-title-link]");
    By backpack = By.cssSelector("[data-test=item-4-title-link]");
    By bikeLight = By.cssSelector("[data-test=item-0-title-link]");
    By boltTShirt = By.cssSelector("[data-test=item-1-title-link]");
    By tShirtRed = By.cssSelector("[data-test=item-3-title-link]");
    By backToShopButton = By.cssSelector("[data-test=continue-shopping]");
    By checkOutButton = By.cssSelector("[data-test=checkout]");

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBackToShop() {
        driver.findElement(backToShopButton).click();
    }

    public void clickCheckout() {
        driver.findElement(checkOutButton).click();
    }

    public String getTextFleeceJacket() {
        return driver.findElement(fleeceJacket).getText();
    }

    public String getTextOnesie() {
        return driver.findElement(onesie).getText();
    }

    public String getTextBackpack() {
        return driver.findElement(backpack).getText();
    }

    public String getTextBikeLight() {
        return driver.findElement(bikeLight).getText();
    }

    public String getTextBoltTShirt() {
        return driver.findElement(boltTShirt).getText();
    }

    public String getTextTShirtRed() {
        return driver.findElement(tShirtRed).getText();
    }
}
