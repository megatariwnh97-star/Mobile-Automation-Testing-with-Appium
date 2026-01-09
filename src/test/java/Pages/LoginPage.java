package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    //Path Element
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement fieldUsername;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement fieldPassword;

    @AndroidFindBy(accessibility = "Tap to login with given credentials")
    private WebElement buttonLogin;

    //Inputan
    // mega@mail.com
    public void inputUsername(String username) {
        fieldUsername.sendKeys(username);
    }
    // Qwery123
    public void inputPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}
