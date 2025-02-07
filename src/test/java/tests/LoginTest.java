package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test(priority = 1, enabled = true, invocationCount = 1, threadPoolSize = 2,
            timeOut = 5000, description = "Вход с верными данными", testName = "Проверка позитивного логина", retryAnalyzer = Retry.class)
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(priority = 2, enabled = true, dependsOnMethods = {"checkPositiveLogin"}, groups = {"smoke", "ui"},
            invocationCount = 1, threadPoolSize = 2, timeOut = 5000, description = "Вход с неверным паролем",
            testName = "Проверка негативного логина с неверным паролем")
    public void checkNegativeLoginWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user","ujfbekj");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @Test(priority = 3, enabled = true, dependsOnMethods = {"checkPositiveLogin"}, groups = {"smoke", "ui"},
            invocationCount = 1, threadPoolSize = 2, timeOut = 5000, description = "Вход с неверным именем пользователя",
            testName = "Проверка негативного логина с неверным именем пользователя")
    public void checkNegativeLoginWrongUser() {
        loginPage.open();
        loginPage.login("wrong_user", "secret_sauce");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @Test(priority = 4, enabled = true, dependsOnMethods = {"checkPositiveLogin"}, groups = {"smoke", "ui"},
            invocationCount = 1, threadPoolSize = 2, timeOut = 5000, description = "Вход без ввода имени пользователя" +
            "и пароля", testName = "Проверка негативного логина без ввода имени пользователя и пароля")
    public void checkNegativeLoginWithoutText() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"wrong_user", "secret_sauce",
                        "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "ujfbekj",
                        "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"}
        };
    }

    @Test(priority = 5, enabled = true, dependsOnMethods = {"checkPositiveLogin"}, groups = {"smoke", "ui"},
            invocationCount = 1, threadPoolSize = 1, timeOut = 8000,
            description = "Выполнение всех негативных логин тестов", testName = "Вход с неверными данными",
            dataProvider = "LoginData")
    public void checkAllNegativeLogin(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                loginPage.getErrorMessage(),
                message,
                "Сообщение об ошибке не появилось");
    }
}
