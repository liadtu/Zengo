package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @AndroidFindBy(id = "com.android.settings:id/password_entry")
    @iOSXCUITFindBy()
    protected MobileElement authenticationField;


    @Step("Type authentication code")
    public void typeAuthenticationCode(String code) {
        fillText(authenticationField, code);
    }
}
