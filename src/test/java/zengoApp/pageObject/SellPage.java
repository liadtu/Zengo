package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SellPage extends BasePage {
    public SellPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@text='Sell']")
    @iOSXCUITFindBy()
    protected MobileElement sellTitle;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected MobileElement bitcoinButton;


    @Step("Return the text of sell title")
    public String sellTitle() {
        return getText(sellTitle);
    }

    @Step("Click on bitcoin button")
    public void clickOnBitcoinButton() {
        click(bitcoinButton);
    }
}
