package tests;

import Core.BaseTest;
import Pages.LoginPage;
import Pages.ProductPage;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @BeforeMethod
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mega@mail.com", "Qwery123");
    }

    @Test
    public void AddProduct() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickBackpackProduct();
        productPage.clickAddToCart();

        Assert.assertEquals(productPage.getCartCount(), "1");
    }
}
