package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    String addToCartPattern = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    By shoppingCart = By.cssSelector("[data-test=shopping-cart-link]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Открытие страницы YourCartPage")
    public void openShoppingCart() {
        driver.findElement(shoppingCart).click();
    }

    @Step("Добавление в корзину товара с именем: {product}")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartPattern, product))).click();
    }
}
