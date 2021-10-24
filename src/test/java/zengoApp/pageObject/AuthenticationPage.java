package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Type authentication code")
    public void typeAuthenticationCode() throws InterruptedException {
        Thread.sleep(10000);
        driver.getKeyboard().pressKey("1");
        driver.getKeyboard().pressKey("2");
        driver.getKeyboard().pressKey("3");
        driver.getKeyboard().pressKey("4");
        clickEnter();
//        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }
}
