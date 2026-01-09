package tests;

import Pages.ProductPage;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Core.BaseTest;
//import Pages.ProductPage;

public class LoginTest extends BaseTest{
    @BeforeMethod
    public void testLogin() {
        driver.findElement(AppiumBy.accessibilityId("View menu")).click();
        driver.findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mega@mail.com", "Qwery123");

        boolean ProductDisplayed = driver.findElement(AppiumBy.id(
                "com.saucelabs.mydemoapp.android:id/productTV")).isDisplayed();
        Assert.assertTrue(ProductDisplayed, "Gagal login: Judul Produk tidak muncul!");
    }

    @Test
    public void AddProduct() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickBackpackProduct();
        productPage.clickAddToCart();

        Assert.assertEquals(productPage.getCartCount(), "1");
    }
}
