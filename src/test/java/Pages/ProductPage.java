package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.AppiumBy.accessibilityId;


public class ProductPage extends BasePage {
    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)")
    private WebElement backpackProduct;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartBt\")")
    private WebElement addToCartButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartTV\")")
    private WebElement cartBadge;

    public void clickBackpackProduct() {
        backpackProduct.click();
    }

    public void clickAddToCart() {
//        driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
//                        + "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartBt\"))"
//        ));
        swipeUp();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        addToCartButton.click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }

    public void addBackpackToCart() {
        clickBackpackProduct();
        clickAddToCart();
    }
}
