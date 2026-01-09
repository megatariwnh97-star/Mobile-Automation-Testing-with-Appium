package Core;

import java.net.MalformedURLException;
import java.time.Duration;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
        protected AndroidDriver driver;

        @BeforeClass
        public void setup() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("emulator-5554")
                    .setApp(System.getProperty("user.dir") + "/apk/demo.apk")
                    .setAutomationName("UiAutomator2")
                    .setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
                    .setAdbExecTimeout(Duration.ofSeconds(10))
                    .setNewCommandTimeout(Duration.ofSeconds(10))
                    .setAppWaitDuration(Duration.ofSeconds(10))
                    .setAppWaitActivity("*")
                    .setNoReset(true);

            try {
                URL appiumServerUrl = new URL("http://127.0.0.1:4723");
                driver = new AndroidDriver(appiumServerUrl, options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
                System.out.println("Appium server started successfully!");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
                System.out.println("Appium server stopped successfully!");
            }
        }
}
