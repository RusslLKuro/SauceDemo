package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {
    WebDriver driver;

    String removeFromCart = "//div[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//button";
    String nameProductInTheCart = "//div[text()='%s']";

    public String getTextFromTheCart(String product) {
        return driver.findElement(By.xpath(String.format(nameProductInTheCart, product))).getText();
    }

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }
}
