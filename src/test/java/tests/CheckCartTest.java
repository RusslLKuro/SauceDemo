package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckCartTest extends BaseTest {

    @Test (testName = "Проверка добавления всех товаров в корзину, а так же их наличия в ней")
    @Description ("Проверка добавления всех товаров в корзину, а так же их наличия в ней")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Shop and cart in SauceDemo")
    @Story("Добавление всех товаров в корзину, а так же их наличия в ней")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-4")
    @Flaky
    public void checkAvailableAllProductsInTheCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.openShoppingCart();
        softAssert.assertEquals(yourCartPage.getTextFromTheCart("Sauce Labs Backpack"),
                "Sauce Labs Backpack",
                "backpack not found");
        softAssert.assertEquals(yourCartPage.getTextFromTheCart("Sauce Labs Fleece Jacket"),
                "Sauce Labs Fleece Jacket",
                "fleece jacket not found");
        softAssert.assertEquals(
                yourCartPage.getTextFromTheCart("Sauce Labs Onesie"),
                "Sauce Labs Onesie",
                "onesie not found");
        softAssert.assertEquals(
                yourCartPage.getTextFromTheCart("Sauce Labs Bike Light"),
                "Sauce Labs Bike Light",
                "bike light not found");
        softAssert.assertEquals(
                yourCartPage.getTextFromTheCart("Sauce Labs Bolt T-Shirt"),
                "Sauce Labs Bolt T-Shirt",
                "bolt T-shirt not found");
        softAssert.assertEquals(
                yourCartPage.getTextFromTheCart("Test.allTheThings() T-Shirt (Red)"),
                "Test.allTheThings() T-Shirt (Red)",
                "red T-shirt not found");
        softAssert.assertAll();
    }
}
