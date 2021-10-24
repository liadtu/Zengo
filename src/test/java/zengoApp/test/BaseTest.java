package zengoApp.test;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void setupZengoAppDriver(ITestContext testContext) throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        cap.setCapability(MobileCapabilityType.UDID, "807KPDT1981226");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zengo.wallet");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zengo.MainActivity");
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability(AndroidMobileCapabilityType.UNLOCK_TYPE, "pin");
        cap.setCapability(AndroidMobileCapabilityType.UNLOCK_KEY, "1234");
        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        cap.setCapability("unicodeKeyboard", true);

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void typeAuthenticationPass() {
        driver.getKeyboard().pressKey("1");
        driver.getKeyboard().pressKey("2");
        driver.getKeyboard().pressKey("3");
        driver.getKeyboard().pressKey("4");
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}