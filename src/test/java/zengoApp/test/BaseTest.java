package zengoApp.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    AppiumDriver<MobileElement> driver;

    //    @Parameters({"platform"})
    @BeforeClass
    public void setup(ITestContext testContext) throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        String platform = "Android";
        switch (platform) {
            case "iOS":
                cap.setCapability("platformName", "iOS");
                cap.setCapability("deviceName", "iPhone");
                cap.setCapability("version", "14.6");
                cap.setCapability("udid", "00008020-000D0D090182002E");
                cap.setCapability("automationName", "XCUITest");
//                cap.setCapability("appActivity", "");
//                cap.setCapability("appPackage", "");

                driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), cap);

                break;
            case "Android":
                cap.setCapability("platformName", "Android");
                cap.setCapability("deviceName", "Galaxy S7");
                cap.setCapability("platformVersion", "8.0.0");
                cap.setCapability("udid", "ce021712d4665f1203");
                cap.setCapability("automationName", "UiAutomator2");
                cap.setCapability("appActivity", "com.zengo.MainActivity");
                cap.setCapability("appPackage", "com.zengo.wallet");
                cap.setCapability("sauceLabsImageInjectionEnabled", true);

                driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);

                break;
            case "AndroidEmulator":
                cap.setCapability("platformName", "Android");
                cap.setCapability("deviceName", "Emulator");
                cap.setCapability("platformVersion", "11.0");
                cap.setCapability("udid", "emulator-5554");
                cap.setCapability("automationName", "UiAutomator2");
                cap.setCapability("appActivity", "com.zengo.MainActivity");
                cap.setCapability("appPackage", "com.zengo.wallet");

                driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.resetApp();
        driver.quit();
    }
}