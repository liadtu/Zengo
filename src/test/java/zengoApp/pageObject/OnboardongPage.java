package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class OnboardongPage extends BasePage{
    public OnboardongPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='onboarding-screen-button-skip']")
    @iOSXCUITFindBy()
    protected MobileElement skipButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='onboarding-screen-email-input']")
    @iOSXCUITFindBy()
    protected MobileElement emailField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='onboarding-screen-button-email-submit']")
    @iOSXCUITFindBy()
    protected MobileElement continueButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected List<MobileElement> emailButtons;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout")
    @iOSXCUITFindBy()
    protected List<MobileElement> mailAppButtons;
}
