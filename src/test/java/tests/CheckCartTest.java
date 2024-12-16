package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckCartTest extends BaseTest {

    @Test
    public void checkAvailableAllProductsInTheCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyAllProducts();
        productsPage.openShoppingCart();
        softAssert.assertEquals(
                yourCartPage.getTextFleeceJacket(),
                "Sauce Labs Fleece Jacket",
                "fleece jacket not found");
        softAssert.assertEquals(
                yourCartPage.getTextOnesie(),
                "Sauce Labs Onesie",
                "onesie not found");
        softAssert.assertEquals(
                yourCartPage.getTextBackpack(),
                "Sauce Labs Backpack",
                "backpack not found");
        softAssert.assertEquals(
                yourCartPage.getTextBikeLight(),
                "Sauce Labs Bike Light",
                "bike light not found");
        softAssert.assertEquals(
                yourCartPage.getTextBoltTShirt(),
                "Sauce Labs Bolt T-Shirt",
                "bolt T-shirt not found");
        softAssert.assertEquals(
                yourCartPage.getTextTShirtRed(),
                "Test.allTheThings() T-Shirt (Red)",
                "red T-shirt not found");
        softAssert.assertAll();
    }
}
