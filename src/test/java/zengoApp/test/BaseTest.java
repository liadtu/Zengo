package zengoApp.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public AppiumDriver<MobileElement> driver = null;

    public String zengoAppPackageName = "com.zengo.wallet";
    public String zengoAppActivityName = "com.zengo.MainActivity";
    public String settingsAppPackageName = "com.android.settings";
    public String settingsAppActivityName = "com.android.settings.ConfirmLockPassword";

    @BeforeClass
    public void setupZengoAppDriver(ITestContext testContext) throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Galaxy S7");
        cap.setCapability("platformVersion", "8.0.0");
        cap.setCapability("udid", "ce021712d4665f1203");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appActivity", zengoAppActivityName);
        cap.setCapability("appPackage", zengoAppPackageName);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability("unlockType", "pin");
        cap.setCapability("unlockKey", "924799");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("exported", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
//        driver.resetApp();
        driver.quit();
    }
}