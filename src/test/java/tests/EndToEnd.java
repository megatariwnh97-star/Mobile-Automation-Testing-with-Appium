package tests;

import Core.BaseTest;
import Pages.LoginPage;
import Pages.ProductPage;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEnd extends BaseTest {
    @Test(priority = 1)
    public void testLogin() {
        driver.findElement(AppiumBy.accessibilityId("View menu")).click();

        driver.findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mega@mail.com", "Qwery123");
    }

    @Test(priority = 2, dependsOnMethods = {"testLogin"})
    public void testAddToCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.addBackpackToCart();

        Assert.assertEquals(productPage.getCartCount(), "1", "Success Adding the product");
    }

}
